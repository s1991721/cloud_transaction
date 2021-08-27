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
import com.jef.transaction.core.model.GlobalStatus;
import com.jef.transaction.core.protocol.ResultCode;
import com.jef.transaction.core.protocol.transaction.GlobalReportResponse;
import com.jef.transaction.serializer.protobuf.generated.*;

/**
 * @author lorne.cl
 */
public class GlobalReportResponseConvertor implements PbConvertor<GlobalReportResponse, GlobalReportResponseProto> {
    @Override
    public GlobalReportResponseProto convert2Proto(GlobalReportResponse globalStatusResponse) {
        final short typeCode = globalStatusResponse.getTypeCode();

        final AbstractMessageProto abstractMessage = AbstractMessageProto.newBuilder().setMessageType(
            MessageTypeProto.forNumber(typeCode)).build();

        final String msg = globalStatusResponse.getMsg();
        final AbstractResultMessageProto abstractResultMessageProto = AbstractResultMessageProto.newBuilder().setMsg(
            msg == null ? "" : msg).setResultCode(ResultCodeProto.valueOf(globalStatusResponse.getResultCode().name()))
            .setAbstractMessage(abstractMessage).build();

        AbstractTransactionResponseProto abstractTransactionResponseProto = AbstractTransactionResponseProto
            .newBuilder().setAbstractResultMessage(abstractResultMessageProto).setTransactionExceptionCode(
                TransactionExceptionCodeProto.valueOf(globalStatusResponse.getTransactionExceptionCode().name()))
            .build();

        AbstractGlobalEndResponseProto abstractGlobalEndResponseProto = AbstractGlobalEndResponseProto.newBuilder()
            .setAbstractTransactionResponse(abstractTransactionResponseProto).setGlobalStatus(
                GlobalStatusProto.valueOf(globalStatusResponse.getGlobalStatus().name())).build();

        GlobalReportResponseProto result = GlobalReportResponseProto.newBuilder().setAbstractGlobalEndResponse(
            abstractGlobalEndResponseProto).build();
        return result;
    }

    @Override
    public GlobalReportResponse convert2Model(GlobalReportResponseProto globalStatusResponseProto) {
        GlobalReportResponse branchRegisterResponse = new GlobalReportResponse();
        final AbstractGlobalEndResponseProto abstractGlobalEndResponse = globalStatusResponseProto
            .getAbstractGlobalEndResponse();
        AbstractTransactionResponseProto abstractResultMessage = abstractGlobalEndResponse
            .getAbstractTransactionResponse();
        branchRegisterResponse.setMsg(abstractResultMessage.getAbstractResultMessage().getMsg());
        branchRegisterResponse.setResultCode(
            ResultCode.valueOf(abstractResultMessage.getAbstractResultMessage().getResultCode().name()));
        branchRegisterResponse.setTransactionExceptionCode(
            TransactionExceptionCode.valueOf(abstractResultMessage.getTransactionExceptionCode().name()));
        branchRegisterResponse.setGlobalStatus(
            GlobalStatus.valueOf(abstractGlobalEndResponse.getGlobalStatus().name()));

        return branchRegisterResponse;

    }
}