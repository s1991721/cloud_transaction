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
package com.jef.transaction.serializer.seata.protocol;

import com.jef.transaction.common.util.StringUtils;
import com.jef.transaction.core.protocol.AbstractResultMessage;
import com.jef.transaction.core.protocol.ResultCode;
import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;

/**
 * The type Abstract result message codec.
 *
 * @author zhangsen
 */
public abstract class AbstractResultMessageCodec extends AbstractMessageCodec {

    @Override
    public Class<?> getMessageClassType() {
        return AbstractResultMessage.class;
    }

    @Override
    public <T> void encode(T t, ByteBuf out) {
        AbstractResultMessage abstractResultMessage = (AbstractResultMessage) t;
        ResultCode resultCode = abstractResultMessage.getResultCode();
        String resultMsg = abstractResultMessage.getMsg();

        out.writeByte(resultCode.ordinal());
        if (resultCode == ResultCode.Failed) {
            if (StringUtils.isNotEmpty(resultMsg)) {
                String msg;
                if (resultMsg.length() > Short.MAX_VALUE) {
                    msg = resultMsg.substring(0, Short.MAX_VALUE);
                } else {
                    msg = resultMsg;
                }
                byte[] bs = msg.getBytes(UTF8);
                out.writeShort((short) bs.length);
                out.writeBytes(bs);
            } else {
                out.writeShort((short) 0);
            }
        }
    }

    @Override
    public <T> void decode(T t, ByteBuffer in) {
        AbstractResultMessage abstractResultMessage = (AbstractResultMessage) t;

        ResultCode resultCode = ResultCode.get(in.get());
        abstractResultMessage.setResultCode(resultCode);
        if (resultCode == ResultCode.Failed) {
            short len = in.getShort();
            if (len > 0) {
                byte[] msg = new byte[len];
                in.get(msg);
                abstractResultMessage.setMsg(new String(msg, UTF8));
            }
        }
    }

}
