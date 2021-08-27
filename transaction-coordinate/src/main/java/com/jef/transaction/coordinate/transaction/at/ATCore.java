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
package com.jef.transaction.coordinate.transaction.at;

import com.jef.transaction.coordinate.coordinator.AbstractCore;
import com.jef.transaction.coordinate.session.BranchSession;
import com.jef.transaction.coordinate.session.GlobalSession;
import com.jef.transaction.core.exception.BranchTransactionException;
import com.jef.transaction.core.exception.TransactionException;
import com.jef.transaction.core.model.BranchType;
import com.jef.transaction.core.rpc.RemotingServer;

import static com.jef.transaction.core.exception.TransactionExceptionCode.LockKeyConflict;

/**
 * The type at core.
 *
 * @author ph3636
 */
public class ATCore extends AbstractCore {

    public ATCore(RemotingServer remotingServer) {
        super(remotingServer);
    }

    @Override
    public BranchType getHandleBranchType() {
        return BranchType.AT;
    }

    @Override
    protected void branchSessionLock(GlobalSession globalSession, BranchSession branchSession) throws TransactionException {
        if (!branchSession.lock()) {
            throw new BranchTransactionException(LockKeyConflict, String
                    .format("Global lock acquire failed xid = %s branchId = %s", globalSession.getXid(),
                            branchSession.getBranchId()));
        }
    }

    @Override
    protected void branchSessionUnlock(BranchSession branchSession) throws TransactionException {
        branchSession.unlock();
    }

    @Override
    public boolean lockQuery(BranchType branchType, String resourceId, String xid, String lockKeys)
            throws TransactionException {
        return lockManager.isLockable(xid, resourceId, lockKeys);
    }
}
