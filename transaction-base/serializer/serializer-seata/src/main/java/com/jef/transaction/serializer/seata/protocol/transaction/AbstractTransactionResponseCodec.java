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

import com.jef.transaction.core.exception.TransactionExceptionCode;
import com.jef.transaction.core.protocol.transaction.AbstractTransactionResponse;
import com.jef.transaction.serializer.seata.protocol.AbstractResultMessageCodec;
import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;

/**
 * The type Abstract transaction response codec.
 *
 * @author zhangsen
 */
public abstract class AbstractTransactionResponseCodec extends AbstractResultMessageCodec {

    @Override
    public Class<?> getMessageClassType() {
        return AbstractTransactionResponse.class;
    }

    @Override
    public <T> void encode(T t, ByteBuf out) {
        super.encode(t, out);

        AbstractTransactionResponse abstractTransactionResponse = (AbstractTransactionResponse)t;
        TransactionExceptionCode transactionExceptionCode = abstractTransactionResponse.getTransactionExceptionCode();
        out.writeByte(transactionExceptionCode.ordinal());
    }

    @Override
    public <T> void decode(T t, ByteBuffer out) {
        super.decode(t, out);

        AbstractTransactionResponse abstractTransactionResponse = (AbstractTransactionResponse)t;
        abstractTransactionResponse.setTransactionExceptionCode(TransactionExceptionCode.get(out.get()));
    }

}
