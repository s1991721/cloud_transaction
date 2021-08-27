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
package com.jef.transaction.serializer.seata.protocol.transaction;

import com.jef.transaction.core.protocol.transaction.BranchRegisterResponse;
import io.netty.buffer.ByteBuf;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * The type Branch register response codec.
 *
 * @author zhangsen
 */
public class BranchRegisterResponseCodec extends AbstractTransactionResponseCodec implements Serializable {

    @Override
    public Class<?> getMessageClassType() {
        return BranchRegisterResponse.class;
    }

    @Override
    public <T> void encode(T t, ByteBuf out) {
        super.encode(t, out);

        BranchRegisterResponse branchRegisterResponse = (BranchRegisterResponse)t;
        long branchId = branchRegisterResponse.getBranchId();
        out.writeLong(branchId);
    }

    @Override
    public <T> void decode(T t, ByteBuffer in) {
        super.decode(t, in);

        BranchRegisterResponse branchRegisterResponse = (BranchRegisterResponse)t;
        branchRegisterResponse.setBranchId(in.getLong());
    }

}
