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

import com.jef.transaction.core.exception.TransactionExceptionCode;
import com.jef.transaction.core.model.BranchStatus;
import com.jef.transaction.core.protocol.ResultCode;
import com.jef.transaction.core.protocol.transaction.BranchCommitResponse;
import com.jef.transaction.serializer.protobuf.generated.*;

/**
 * @author leizhiyuan
 */
public class BranchCommitResponseConvertor implements PbConvertor<BranchCommitResponse, BranchCommitResponseProto> {
    @Override
    public BranchCommitResponseProto convert2Proto(BranchCommitResponse branchCommitResponse) {
        final short typeCode = branchCommitResponse.getTypeCode();

        final AbstractMessageProto abstractMessage = AbstractMessageProto.newBuilder().setMessageType(
            MessageTypeProto.forNumber(typeCode)).build();

        final String msg = branchCommitResponse.getMsg();
        final AbstractResultMessageProto abstractResultMessageProto = AbstractResultMessageProto.newBuilder().setMsg(
            msg == null ? "" : msg).setResultCode(ResultCodeProto.valueOf(branchCommitResponse.getResultCode().name()))
            .setAbstractMessage(abstractMessage).build();

        final AbstractTransactionResponseProto abstractTransactionRequestProto = AbstractTransactionResponseProto
            .newBuilder().setAbstractResultMessage(abstractResultMessageProto).setTransactionExceptionCode(
                TransactionExceptionCodeProto.valueOf(branchCommitResponse.getTransactionExceptionCode().name()))
            .build();

        final AbstractBranchEndResponseProto abstractBranchEndResponse = AbstractBranchEndResponseProto.newBuilder().
            setAbstractTransactionResponse(abstractTransactionRequestProto).setXid(branchCommitResponse.getXid())
            .setBranchId(branchCommitResponse.getBranchId()).setBranchStatus(
                BranchStatusProto.forNumber(branchCommitResponse.getBranchStatus().getCode())).build();

        BranchCommitResponseProto result = BranchCommitResponseProto.newBuilder().setAbstractBranchEndResponse(
            abstractBranchEndResponse).build();
        return result;
    }

    @Override
    public BranchCommitResponse convert2Model(BranchCommitResponseProto branchCommitResponseProto) {

        BranchCommitResponse branchCommitResponse = new BranchCommitResponse();
        branchCommitResponse.setBranchId(branchCommitResponseProto.getAbstractBranchEndResponse().getBranchId());
        branchCommitResponse.setBranchStatus(
            BranchStatus.get(branchCommitResponseProto.getAbstractBranchEndResponse().getBranchStatusValue()));
        branchCommitResponse.setXid(branchCommitResponseProto.getAbstractBranchEndResponse().getXid());
        branchCommitResponse.setMsg(
            branchCommitResponseProto.getAbstractBranchEndResponse().getAbstractTransactionResponse()
                .getAbstractResultMessage().getMsg());
        branchCommitResponse.setResultCode(ResultCode.valueOf(
            branchCommitResponseProto.getAbstractBranchEndResponse().getAbstractTransactionResponse()
                .getAbstractResultMessage().getResultCode().name()));

        branchCommitResponse.setTransactionExceptionCode(TransactionExceptionCode.valueOf(
            branchCommitResponseProto.getAbstractBranchEndResponse().getAbstractTransactionResponse()
                .getTransactionExceptionCode().name()));
        return branchCommitResponse;
    }
}