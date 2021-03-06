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
import com.jef.transaction.core.protocol.transaction.BranchRegisterRequest;
import com.jef.transaction.serializer.protobuf.generated.*;

/**
 * @author leizhiyuan
 */
public class BranchRegisterRequestConvertor implements PbConvertor<BranchRegisterRequest, BranchRegisterRequestProto> {
    @Override
    public BranchRegisterRequestProto convert2Proto(BranchRegisterRequest branchRegisterRequest) {
        final short typeCode = branchRegisterRequest.getTypeCode();

        final AbstractMessageProto abstractMessage = AbstractMessageProto.newBuilder().setMessageType(
            MessageTypeProto.forNumber(typeCode)).build();

        final AbstractTransactionRequestProto abstractTransactionRequestProto = AbstractTransactionRequestProto
            .newBuilder().setAbstractMessage(abstractMessage).build();

        final String applicationData = branchRegisterRequest.getApplicationData();
        final String resourceId = branchRegisterRequest.getResourceId();
        final String lockKey = branchRegisterRequest.getLockKey();
        BranchRegisterRequestProto result = BranchRegisterRequestProto.newBuilder().setAbstractTransactionRequest(
            abstractTransactionRequestProto).setApplicationData(applicationData == null ? "" : applicationData)
            .setBranchType(BranchTypeProto.valueOf(branchRegisterRequest.getBranchType().name())).setLockKey(
                lockKey == null ? "" : lockKey).setResourceId(resourceId == null ? "" : resourceId).setXid(
                branchRegisterRequest.getXid()).build();
        return result;
    }

    @Override
    public BranchRegisterRequest convert2Model(BranchRegisterRequestProto branchRegisterRequestProto) {
        BranchRegisterRequest branchRegisterRequest = new BranchRegisterRequest();
        branchRegisterRequest.setApplicationData(branchRegisterRequestProto.getApplicationData());
        branchRegisterRequest.setBranchType(BranchType.valueOf(branchRegisterRequestProto.getBranchType().name()));
        branchRegisterRequest.setLockKey(branchRegisterRequestProto.getLockKey());
        branchRegisterRequest.setResourceId(branchRegisterRequestProto.getResourceId());
        branchRegisterRequest.setXid(branchRegisterRequestProto.getXid());
        return branchRegisterRequest;
    }
}