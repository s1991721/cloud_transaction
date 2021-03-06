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
package com.jef.transaction.discovery.loadbalance;


import com.jef.transaction.common.util.CollectionUtils;

import java.util.List;

/**
 * The type Abstract load balance.
 *
 * @author slievrly
 */
public abstract class AbstractLoadBalance implements LoadBalance {

    @Override
    public <T> T select(List<T> invokers, String xid) {
        if (CollectionUtils.isEmpty(invokers)) {
            return null;
        }
        if (invokers.size() == 1) {
            return invokers.get(0);
        }
        return doSelect(invokers, xid);
    }

    /**
     * Do select t.
     *
     * @param <T>      the type parameter
     * @param invokers the invokers
     * @param xid      the xid
     * @return the t
     */
    protected abstract <T> T doSelect(List<T> invokers, String xid);
}
