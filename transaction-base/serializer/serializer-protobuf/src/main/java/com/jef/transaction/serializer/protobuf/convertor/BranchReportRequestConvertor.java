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

import com.jef.transaction.core.model.BranchStatus;
import com.jef.transaction.core.model.BranchType;
import com.jef.transaction.core.protocol.transaction.BranchReportRequest;
import com.jef.transaction.serializer.protobuf.generated.*;

/**
 * @author leizhiyuan
 */
public class BranchReportRequestConvertor implements PbConvertor<BranchReportRequest, BranchReportRequestProto> {
    @Override
    public BranchReportRequestProto convert2Proto(BranchReportRequest branchReportRequest) {
        final short typeCode = branchReportRequest.getTypeCode();

        final AbstractMessageProto abstractMessage = AbstractMessageProto.newBuilder().setMessageType(
            MessageTypeProto.forNumber(typeCode)).build();

        final AbstractTransactionRequestProto abstractTransactionRequestProto = AbstractTransactionRequestProto
            .newBuilder().setAbstractMessage(abstractMessage).build();

        final String applicationData = branchReportRequest.getApplicationData();
        final String resourceId = branchReportRequest.getResourceId();
        BranchReportRequestProto result = BranchReportRequestProto.newBuilder().setAbstractTransactionRequest(
            abstractTransactionRequestProto).setXid(branchReportRequest.getXid()).setBranchId(
            branchReportRequest.getBranchId()).setBranchType(
            BranchTypeProto.valueOf(branchReportRequest.getBranchType().name())).setApplicationData(
            applicationData == null ? "" : applicationData).setResourceId(resourceId == null ? "" : resourceId)
            .setStatus(BranchStatusProto.valueOf(branchReportRequest.getStatus().name())).build();

        return result;
    }

    @Override
    public BranchReportRequest convert2Model(BranchReportRequestProto branchReportRequestProto) {
        BranchReportRequest branchReportRequest = new BranchReportRequest();
        branchReportRequest.setApplicationData(branchReportRequestProto.getApplicationData());
        branchReportRequest.setBranchId(branchReportRequestProto.getBranchId());
        branchReportRequest.setResourceId(branchReportRequestProto.getResourceId());
        branchReportRequest.setXid(branchReportRequestProto.getXid());
        branchReportRequest.setBranchType(BranchType.valueOf(branchReportRequestProto.getBranchType().name()));
        branchReportRequest.setStatus(BranchStatus.valueOf(branchReportRequestProto.getStatus().name()));
        return branchReportRequest;
    }
}