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

import com.jef.transaction.core.protocol.transaction.GlobalCommitRequest;
import com.jef.transaction.serializer.protobuf.generated.*;

/**
 * @author leizhiyuan
 */
public class GlobalCommitRequestConvertor implements PbConvertor<GlobalCommitRequest, GlobalCommitRequestProto> {
    @Override
    public GlobalCommitRequestProto convert2Proto(GlobalCommitRequest globalCommitRequest) {
        final short typeCode = globalCommitRequest.getTypeCode();

        final AbstractMessageProto abstractMessage = AbstractMessageProto.newBuilder().setMessageType(
            MessageTypeProto.forNumber(typeCode)).build();

        final AbstractTransactionRequestProto abstractTransactionRequestProto = AbstractTransactionRequestProto
            .newBuilder().setAbstractMessage(abstractMessage).build();

        final String extraData = globalCommitRequest.getExtraData();
        AbstractGlobalEndRequestProto abstractGlobalEndRequestProto = AbstractGlobalEndRequestProto.newBuilder()
            .setAbstractTransactionRequest(abstractTransactionRequestProto).setXid(globalCommitRequest.getXid())
            .setExtraData(extraData == null ? "" : extraData).build();

        GlobalCommitRequestProto result = GlobalCommitRequestProto.newBuilder().setAbstractGlobalEndRequest(
            abstractGlobalEndRequestProto).build();

        return result;

    }

    @Override
    public GlobalCommitRequest convert2Model(GlobalCommitRequestProto globalCommitRequestProto) {
        GlobalCommitRequest branchCommitRequest = new GlobalCommitRequest();
        branchCommitRequest.setExtraData(globalCommitRequestProto.getAbstractGlobalEndRequest().getExtraData());
        branchCommitRequest.setXid(globalCommitRequestProto.getAbstractGlobalEndRequest().getXid());
        return branchCommitRequest;
    }
}