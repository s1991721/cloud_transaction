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
import com.jef.transaction.core.protocol.transaction.BranchCommitRequest;
import com.jef.transaction.serializer.protobuf.generated.*;

/**
 * @author leizhiyuan
 */
public class BranchCommitRequestConvertor implements PbConvertor<BranchCommitRequest, BranchCommitRequestProto> {
    @Override
    public BranchCommitRequestProto convert2Proto(BranchCommitRequest branchCommitRequest) {
        final short typeCode = branchCommitRequest.getTypeCode();

        final AbstractMessageProto abstractMessage = AbstractMessageProto.newBuilder().setMessageType(
            MessageTypeProto.forNumber(typeCode)).build();

        final AbstractTransactionRequestProto abstractTransactionRequestProto = AbstractTransactionRequestProto
            .newBuilder().setAbstractMessage(abstractMessage).build();

        final String applicationData = branchCommitRequest.getApplicationData();
        final AbstractBranchEndRequestProto abstractBranchEndRequestProto = AbstractBranchEndRequestProto.newBuilder().
            setAbstractTransactionRequest(abstractTransactionRequestProto).setXid(branchCommitRequest.getXid())
            .setBranchId(branchCommitRequest.getBranchId()).setBranchType(
                BranchTypeProto.valueOf(branchCommitRequest.getBranchType().name())).setApplicationData(
                applicationData == null ? "" : applicationData).setResourceId(branchCommitRequest.getResourceId())
            .build();

        BranchCommitRequestProto result = BranchCommitRequestProto.newBuilder().setAbstractBranchEndRequest(
            abstractBranchEndRequestProto).build();
        return result;
    }

    @Override
    public BranchCommitRequest convert2Model(BranchCommitRequestProto branchCommitRequestProto) {
        BranchCommitRequest branchCommitRequest = new BranchCommitRequest();
        branchCommitRequest.setApplicationData(
            branchCommitRequestProto.getAbstractBranchEndRequest().getApplicationData());
        branchCommitRequest.setBranchId(branchCommitRequestProto.getAbstractBranchEndRequest().getBranchId());
        branchCommitRequest.setResourceId(branchCommitRequestProto.getAbstractBranchEndRequest().getResourceId());
        branchCommitRequest.setXid(branchCommitRequestProto.getAbstractBranchEndRequest().getXid());
        branchCommitRequest.setBranchType(
            BranchType.valueOf(branchCommitRequestProto.getAbstractBranchEndRequest().getBranchType().name()));

        return branchCommitRequest;
    }
}