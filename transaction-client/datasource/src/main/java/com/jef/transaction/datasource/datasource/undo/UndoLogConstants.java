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
package com.jef.transaction.datasource.datasource.undo;

import com.jef.transaction.config.ConfigurationFactory;
import com.jef.transaction.core.constants.ConfigurationKeys;

import static com.jef.transaction.common.DefaultValues.DEFAULT_TRANSACTION_UNDO_LOG_SERIALIZATION;

/**
 * @author Geng Zhang
 */
public interface UndoLogConstants {

    String SERIALIZER_KEY = "serializer";

    String DEFAULT_SERIALIZER = ConfigurationFactory.getInstance()
        .getConfig(ConfigurationKeys.TRANSACTION_UNDO_LOG_SERIALIZATION, DEFAULT_TRANSACTION_UNDO_LOG_SERIALIZATION);

    String COMPRESSOR_TYPE_KEY = "compressorType";
}
