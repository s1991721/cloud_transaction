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
package com.jef.transaction.core.rpc.processor.client;

import io.netty.channel.ChannelHandlerContext;
import com.jef.transaction.common.util.NetUtil;
import com.jef.transaction.core.protocol.RpcMessage;
import com.jef.transaction.core.protocol.transaction.BranchRollbackRequest;
import com.jef.transaction.core.protocol.transaction.BranchRollbackResponse;
import com.jef.transaction.core.rpc.RemotingClient;
import com.jef.transaction.core.rpc.TransactionMessageHandler;
import com.jef.transaction.core.rpc.processor.RemotingProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * process TC do global rollback command.
 * <p>
 * process message type:
 * {@link BranchRollbackRequest}
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 1.3.0
 */
public class RmBranchRollbackProcessor implements RemotingProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RmBranchRollbackProcessor.class);

    private TransactionMessageHandler handler;

    private RemotingClient remotingClient;

    public RmBranchRollbackProcessor(TransactionMessageHandler handler, RemotingClient remotingClient) {
        this.handler = handler;
        this.remotingClient = remotingClient;
    }

    @Override
    public void process(ChannelHandlerContext ctx, RpcMessage rpcMessage) throws Exception {
        String remoteAddress = NetUtil.toStringAddress(ctx.channel().remoteAddress());
        Object msg = rpcMessage.getBody();
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("rm handle branch rollback process:" + msg);
        }
        handleBranchRollback(rpcMessage, remoteAddress, (BranchRollbackRequest) msg);
    }

    private void handleBranchRollback(RpcMessage request, String serverAddress, BranchRollbackRequest branchRollbackRequest) {
        BranchRollbackResponse resultMessage;
        resultMessage = (BranchRollbackResponse) handler.onRequest(branchRollbackRequest, null);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("branch rollback result:" + resultMessage);
        }
        try {
            this.remotingClient.sendAsyncResponse(serverAddress, request, resultMessage);
        } catch (Throwable throwable) {
            LOGGER.error("send response error: {}", throwable.getMessage(), throwable);
        }
    }
}
