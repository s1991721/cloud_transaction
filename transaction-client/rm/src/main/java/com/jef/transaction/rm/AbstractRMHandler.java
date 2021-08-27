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
package com.jef.transaction.rm;

import com.jef.transaction.core.exception.AbstractExceptionHandler;
import com.jef.transaction.core.exception.TransactionException;
import com.jef.transaction.core.model.BranchStatus;
import com.jef.transaction.core.model.BranchType;
import com.jef.transaction.core.model.ResourceManager;
import com.jef.transaction.core.protocol.AbstractMessage;
import com.jef.transaction.core.protocol.AbstractResultMessage;
import com.jef.transaction.core.protocol.transaction.*;
import com.jef.transaction.core.rpc.RpcContext;
import com.jef.transaction.core.rpc.TransactionMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Abstract RM event handler
 *
 * @author sharajava
 */
public abstract class AbstractRMHandler extends AbstractExceptionHandler
    implements RMInboundHandler, TransactionMessageHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRMHandler.class);

    @Override
    public BranchCommitResponse handle(BranchCommitRequest request) {
        BranchCommitResponse response = new BranchCommitResponse();
        exceptionHandleTemplate(new AbstractCallback<BranchCommitRequest, BranchCommitResponse>() {
            @Override
            public void execute(BranchCommitRequest request, BranchCommitResponse response)
                throws TransactionException {
                doBranchCommit(request, response);
            }
        }, request, response);
        return response;
    }

    @Override
    public BranchRollbackResponse handle(BranchRollbackRequest request) {
        BranchRollbackResponse response = new BranchRollbackResponse();
        exceptionHandleTemplate(new AbstractCallback<BranchRollbackRequest, BranchRollbackResponse>() {
            @Override
            public void execute(BranchRollbackRequest request, BranchRollbackResponse response)
                throws TransactionException {
                doBranchRollback(request, response);
            }
        }, request, response);
        return response;
    }

    /**
     * delete undo log
     * @param request the request
     */
    @Override
    public void handle(UndoLogDeleteRequest request) {
        // https://github.com/seata/seata/issues/2226
    }

    /**
     * Do branch commit.
     *
     * @param request  the request
     * @param response the response
     * @throws TransactionException the transaction exception
     */
    protected void doBranchCommit(BranchCommitRequest request, BranchCommitResponse response)
        throws TransactionException {
        String xid = request.getXid();
        long branchId = request.getBranchId();
        String resourceId = request.getResourceId();
        String applicationData = request.getApplicationData();
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Branch committing: " + xid + " " + branchId + " " + resourceId + " " + applicationData);
        }
        BranchStatus status = getResourceManager().branchCommit(request.getBranchType(), xid, branchId, resourceId,
            applicationData);
        response.setXid(xid);
        response.setBranchId(branchId);
        response.setBranchStatus(status);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Branch commit result: " + status);
        }

    }

    /**
     * Do branch rollback.
     *
     * @param request  the request
     * @param response the response
     * @throws TransactionException the transaction exception
     */
    protected void doBranchRollback(BranchRollbackRequest request, BranchRollbackResponse response)
        throws TransactionException {
        String xid = request.getXid();
        long branchId = request.getBranchId();
        String resourceId = request.getResourceId();
        String applicationData = request.getApplicationData();
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Branch Rollbacking: " + xid + " " + branchId + " " + resourceId);
        }
        BranchStatus status = getResourceManager().branchRollback(request.getBranchType(), xid, branchId, resourceId,
            applicationData);
        response.setXid(xid);
        response.setBranchId(branchId);
        response.setBranchStatus(status);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Branch Rollbacked result: " + status);
        }
    }

    /**
     * get resource manager implement
     *
     * @return resource manager
     */
    protected abstract ResourceManager getResourceManager();

    @Override
    public AbstractResultMessage onRequest(AbstractMessage request, RpcContext context) {
        if (!(request instanceof AbstractTransactionRequestToRM)) {
            throw new IllegalArgumentException();
        }
        AbstractTransactionRequestToRM transactionRequest = (AbstractTransactionRequestToRM)request;
        transactionRequest.setRMInboundMessageHandler(this);

        return transactionRequest.handle(context);
    }

    @Override
    public void onResponse(AbstractResultMessage response, RpcContext context) {
        LOGGER.info("the rm client received response msg [{}] from tc server.", response.toString());
    }

    public abstract BranchType getBranchType();
}
