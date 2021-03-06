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
package com.jef.transaction.core.rpc;

import io.netty.channel.ChannelHandlerContext;
import com.jef.transaction.core.protocol.RpcMessage;

/**
 * The interface Server message listener.
 *
 * @author slievrly
 */
@Deprecated
public interface ServerMessageListener {

    /**
     * On trx message.
     *
     * @param request the msg id
     * @param ctx     the ctx
     */
    void onTrxMessage(RpcMessage request, ChannelHandlerContext ctx);

    /**
     * On reg rm message.
     *
     * @param request          the msg id
     * @param ctx              the ctx
     * @param checkAuthHandler the check auth handler
     */
    void onRegRmMessage(RpcMessage request, ChannelHandlerContext ctx, RegisterCheckAuthHandler checkAuthHandler);

    /**
     * On reg tm message.
     *
     * @param request          the msg id
     * @param ctx              the ctx
     * @param checkAuthHandler the check auth handler
     */
    void onRegTmMessage(RpcMessage request, ChannelHandlerContext ctx, RegisterCheckAuthHandler checkAuthHandler);

    /**
     * On check message.
     *
     * @param request the msg id
     * @param ctx     the ctx
     */
    void onCheckMessage(RpcMessage request, ChannelHandlerContext ctx);

}
