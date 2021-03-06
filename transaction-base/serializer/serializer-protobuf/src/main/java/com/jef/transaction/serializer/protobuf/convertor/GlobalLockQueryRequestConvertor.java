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

import com.jef.transaction.core.model.BranchType;
import com.jef.transaction.core.protocol.transaction.GlobalLockQueryRequest;
import com.jef.transaction.serializer.protobuf.generated.*;

/**
 * @author leizhiyuan
 */
public class GlobalLockQueryRequestConvertor
    implements PbConvertor<GlobalLockQueryRequest, GlobalLockQueryRequestProto> {
    @Override
    public GlobalLockQueryRequestProto convert2Proto(GlobalLockQueryRequest globalLockQueryRequest) {
        final short typeCode = globalLockQueryRequest.getTypeCode();

        final AbstractMessageProto abstractMessage = AbstractMessageProto.newBuilder().setMessageType(
            MessageTypeProto.forNumber(typeCode)).build();

        final AbstractTransactionRequestProto abstractTransactionRequestProto = AbstractTransactionRequestProto
            .newBuilder().setAbstractMessage(abstractMessage).build();

        final String applicationData = globalLockQueryRequest.getApplicationData();
        final String lockKey = globalLockQueryRequest.getLockKey();
        BranchRegisterRequestProto branchRegisterRequestProto = BranchRegisterRequestProto.newBuilder()
            .setAbstractTransactionRequest(abstractTransactionRequestProto).setApplicationData(
                applicationData == null ? "" : applicationData).setBranchType(
                BranchTypeProto.valueOf(globalLockQueryRequest.getBranchType().name())).setLockKey(
                lockKey == null ? "" : lockKey).setResourceId(globalLockQueryRequest.getResourceId()).setXid(
                globalLockQueryRequest.getXid()).build();

        GlobalLockQueryRequestProto result = GlobalLockQueryRequestProto.newBuilder().setBranchRegisterRequest(
            branchRegisterRequestProto).build();

        return result;
    }

    @Override
    public GlobalLockQueryRequest convert2Model(GlobalLockQueryRequestProto globalLockQueryRequestProto) {
        GlobalLockQueryRequest branchRegisterRequest = new GlobalLockQueryRequest();
        BranchRegisterRequestProto branchRegisterRequestProto = globalLockQueryRequestProto.getBranchRegisterRequest();
        branchRegisterRequest.setApplicationData(branchRegisterRequestProto.getApplicationData());
        branchRegisterRequest.setBranchType(BranchType.valueOf(branchRegisterRequestProto.getBranchType().name()));
        branchRegisterRequest.setLockKey(branchRegisterRequestProto.getLockKey());
        branchRegisterRequest.setResourceId(branchRegisterRequestProto.getResourceId());
        branchRegisterRequest.setXid(branchRegisterRequestProto.getXid());
        return branchRegisterRequest;
    }
}