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

import com.jef.transaction.core.protocol.*;
import com.jef.transaction.core.protocol.transaction.*;
import com.jef.transaction.core.rpc.TransactionMessageHandler;
import com.jef.transaction.core.rpc.processor.RemotingProcessor;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * process TC response message.
 * <p>
 * process message type:
 * RM:
 * 1) {@link MergeResultMessage}
 * 2) {@link RegisterRMResponse}
 * 3) {@link BranchRegisterResponse}
 * 4) {@link BranchReportResponse}
 * 5) {@link GlobalLockQueryResponse}
 * TM:
 * 1) {@link MergeResultMessage}
 * 2) {@link RegisterTMResponse}
 * 3) {@link GlobalBeginResponse}
 * 4) {@link GlobalCommitResponse}
 * 5) {@link GlobalReportResponse}
 * 6) {@link GlobalRollbackResponse}
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 1.3.0
 */
public class ClientOnResponseProcessor implements RemotingProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientOnResponseProcessor.class);

    /**
     * The Merge msg map from io.seata.core.rpc.netty.AbstractNettyRemotingClient#mergeMsgMap.
     */
    private Map<Integer, MergeMessage> mergeMsgMap;

    /**
     * The Futures from io.seata.core.rpc.netty.AbstractNettyRemoting#futures
     */
    private ConcurrentMap<Integer, MessageFuture> futures;

    /**
     * To handle the received RPC message on upper level.
     */
    private TransactionMessageHandler transactionMessageHandler;

    public ClientOnResponseProcessor(Map<Integer, MergeMessage> mergeMsgMap,
                                     ConcurrentHashMap<Integer, MessageFuture> futures,
                                     TransactionMessageHandler transactionMessageHandler) {
        this.mergeMsgMap = mergeMsgMap;
        this.futures = futures;
        this.transactionMessageHandler = transactionMessageHandler;
    }

    @Override
    public void process(ChannelHandlerContext ctx, RpcMessage rpcMessage) throws Exception {
        if (rpcMessage.getBody() instanceof MergeResultMessage) {
            MergeResultMessage results = (MergeResultMessage) rpcMessage.getBody();
            MergedWarpMessage mergeMessage = (MergedWarpMessage) mergeMsgMap.remove(rpcMessage.getId());
            for (int i = 0; i < mergeMessage.msgs.size(); i++) {
                int msgId = mergeMessage.msgIds.get(i);
                MessageFuture future = futures.remove(msgId);
                if (future == null) {
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.info("msg: {} is not found in futures.", msgId);
                    }
                } else {
                    future.setResultMessage(results.getMsgs()[i]);
                }
            }
        } else {
            MessageFuture messageFuture = futures.remove(rpcMessage.getId());
            if (messageFuture != null) {
                messageFuture.setResultMessage(rpcMessage.getBody());
            } else {
                if (rpcMessage.getBody() instanceof AbstractResultMessage) {
                    if (transactionMessageHandler != null) {
                        transactionMessageHandler.onResponse((AbstractResultMessage) rpcMessage.getBody(), null);
                    }
                }
            }
        }
    }
}
