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
import com.jef.transaction.core.protocol.transaction.BranchRollbackResponse;
import com.jef.transaction.serializer.protobuf.generated.*;

/**
 * @author leizhiyuan
 */
public class BranchRollbackResponseConvertor
    implements PbConvertor<BranchRollbackResponse, BranchRollbackResponseProto> {
    @Override
    public BranchRollbackResponseProto convert2Proto(BranchRollbackResponse branchRollbackResponse) {
        final short typeCode = branchRollbackResponse.getTypeCode();

        final AbstractMessageProto abstractMessage = AbstractMessageProto.newBuilder().setMessageType(
            MessageTypeProto.forNumber(typeCode)).build();

        final String msg = branchRollbackResponse.getMsg();
        final AbstractResultMessageProto abstractResultMessageProto = AbstractResultMessageProto.newBuilder().setMsg(
            msg == null ? "" : msg).setResultCode(
            ResultCodeProto.valueOf(branchRollbackResponse.getResultCode().name())).setAbstractMessage(abstractMessage)
            .build();

        final AbstractTransactionResponseProto abstractTransactionRequestProto = AbstractTransactionResponseProto
            .newBuilder().setAbstractResultMessage(abstractResultMessageProto).setTransactionExceptionCode(
                TransactionExceptionCodeProto.valueOf(branchRollbackResponse.getTransactionExceptionCode().name()))
            .build();

        final AbstractBranchEndResponseProto abstractBranchEndResponse = AbstractBranchEndResponseProto.newBuilder().
            setAbstractTransactionResponse(abstractTransactionRequestProto).setXid(branchRollbackResponse.getXid())
            .setBranchId(branchRollbackResponse.getBranchId()).setBranchStatus(
                BranchStatusProto.forNumber(branchRollbackResponse.getBranchStatus().getCode())).build();

        BranchRollbackResponseProto result = BranchRollbackResponseProto.newBuilder().setAbstractBranchEndResponse(
            abstractBranchEndResponse).build();

        return result;
    }

    @Override
    public BranchRollbackResponse convert2Model(BranchRollbackResponseProto branchRollbackResponseProto) {
        BranchRollbackResponse branchCommitResponse = new BranchRollbackResponse();
        branchCommitResponse.setBranchId(branchRollbackResponseProto.getAbstractBranchEndResponse().getBranchId());
        branchCommitResponse.setBranchStatus(
            BranchStatus.get(branchRollbackResponseProto.getAbstractBranchEndResponse().getBranchStatusValue()));
        branchCommitResponse.setXid(branchRollbackResponseProto.getAbstractBranchEndResponse().getXid());
        branchCommitResponse.setMsg(
            branchRollbackResponseProto.getAbstractBranchEndResponse().getAbstractTransactionResponse()
                .getAbstractResultMessage().getMsg());
        branchCommitResponse.setResultCode(ResultCode.valueOf(
            branchRollbackResponseProto.getAbstractBranchEndResponse().getAbstractTransactionResponse()
                .getAbstractResultMessage().getResultCode().name()));

        branchCommitResponse.setTransactionExceptionCode(TransactionExceptionCode.valueOf(
            branchRollbackResponseProto.getAbstractBranchEndResponse().getAbstractTransactionResponse()
                .getTransactionExceptionCode().name()));
        return branchCommitResponse;
    }
}