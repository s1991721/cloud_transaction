/*
 *  Copyright 1999-2019 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.jef.transaction.metrics.registry.compact;


import com.jef.transaction.common.loader.LoadLevel;
import com.jef.transaction.common.util.CollectionUtils;
import com.jef.transaction.metrics.api.*;
import com.jef.transaction.metrics.api.registry.Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * Compact Registry implement, this registry only compute all Measurements when call measure method and do not cache
 *
 * @author zhengyangyong
 */
@LoadLevel(name = "compact", order = 1)
public class CompactRegistry implements Registry {
    private static final Map<UUID, Meter> METERS = new ConcurrentHashMap<>();

    @Override
    public <T extends Number> Gauge<T> getGauge(Id id, Supplier<T> supplier) {
        return (Gauge<T>) CollectionUtils.computeIfAbsent(METERS, id.getId(), key -> new CompactGauge<>(id, supplier));
    }

    @Override
    public Counter getCounter(Id id) {
        return (Counter) CollectionUtils.computeIfAbsent(METERS, id.getId(), key -> new CompactCounter(id));
    }

    @Override
    public Summary getSummary(Id id) {
        return (Summary) CollectionUtils.computeIfAbsent(METERS, id.getId(), key -> new CompactSummary(id));
    }

    @Override
    public Timer getTimer(Id id) {
        return (Timer) CollectionUtils.computeIfAbsent(METERS, id.getId(), key -> new CompactTimer(id));
    }

    @Override
    public Iterable<Measurement> measure() {
        final List<Measurement> measurements = new ArrayList<>();
        if (METERS.isEmpty()) {
            return measurements;
        }
        METERS.values().iterator()
                .forEachRemaining(meter -> meter.measure().forEach(measurements::add));
        return measurements;
    }
}
