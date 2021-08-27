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
package com.jef.transaction.serializer.protobuf.convertor;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.jef.transaction.common.exception.ShouldNeverHappenException;
import com.jef.transaction.core.protocol.AbstractMessage;
import com.jef.transaction.core.protocol.AbstractResultMessage;
import com.jef.transaction.core.protocol.MergeResultMessage;
import com.jef.transaction.serializer.protobuf.generated.AbstractMessageProto;
import com.jef.transaction.serializer.protobuf.generated.MergedResultMessageProto;
import com.jef.transaction.serializer.protobuf.generated.MessageTypeProto;
import com.jef.transaction.serializer.protobuf.manager.ProtobufConvertManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leizhiyuan
 */
public class MergeResultMessageConvertor implements PbConvertor<MergeResultMessage, MergedResultMessageProto> {
    @Override
    public MergedResultMessageProto convert2Proto(MergeResultMessage mergeResultMessage) {
        final short typeCode = mergeResultMessage.getTypeCode();

        final AbstractMessageProto abstractMessage = AbstractMessageProto.newBuilder().setMessageType(
                MessageTypeProto.forNumber(typeCode)).build();

        List<Any> lists = new ArrayList<>();
        for (AbstractMessage msg : mergeResultMessage.msgs) {
            final PbConvertor pbConvertor = ProtobufConvertManager.getInstance().fetchConvertor(
                    msg.getClass().getName());
            lists.add(Any.pack((Message) pbConvertor.convert2Proto(msg)));
        }

        MergedResultMessageProto mergedWarpMessageProto = MergedResultMessageProto.newBuilder().setAbstractMessage(
                abstractMessage).addAllMsgs(lists).build();

        return mergedWarpMessageProto;
    }

    @Override
    public MergeResultMessage convert2Model(MergedResultMessageProto mergedResultMessageProto) {
        MergeResultMessage result = new MergeResultMessage();
        List<Any> anys = mergedResultMessageProto.getMsgsList();

        List<AbstractResultMessage> temp = new ArrayList<>();
        for (Any any : anys) {
            final Class clazz = ProtobufConvertManager.getInstance().fetchProtoClass(
                    getTypeNameFromTypeUrl(any.getTypeUrl()));
            if (any.is(clazz)) {
                try {
                    Object ob = any.unpack(clazz);
                    final PbConvertor pbConvertor = ProtobufConvertManager.getInstance().fetchReversedConvertor(
                            clazz.getName());
                    Object model = pbConvertor.convert2Model(ob);
                    temp.add((AbstractResultMessage) model);
                } catch (InvalidProtocolBufferException e) {
                    throw new ShouldNeverHappenException(e);
                }
            }
        }
        result.setMsgs(temp.toArray(new AbstractResultMessage[temp.size()]));

        return result;
    }

    private static String getTypeNameFromTypeUrl(String typeUrl) {
        int pos = typeUrl.lastIndexOf('/');
        return pos == -1 ? "" : typeUrl.substring(pos + 1);
    }
}