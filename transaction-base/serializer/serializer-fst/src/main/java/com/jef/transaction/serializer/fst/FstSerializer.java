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
package com.jef.transaction.serializer.fst;


import com.jef.transaction.common.loader.LoadLevel;
import com.jef.transaction.core.serializer.Serializer;

/**
 * @author funkye
 */
@LoadLevel(name = "FST")
public class FstSerializer implements Serializer {

    private FstSerializerFactory fstFactory = FstSerializerFactory.getDefaultFactory();

    @Override
    public <T> byte[] serialize(T t) {
        return fstFactory.serialize(t);
    }

    @Override
    public <T> T deserialize(byte[] bytes) {
        return (T)fstFactory.deserialize(bytes);
    }

}
