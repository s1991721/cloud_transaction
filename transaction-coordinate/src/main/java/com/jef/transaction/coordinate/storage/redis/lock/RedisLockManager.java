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
package com.jef.transaction.coordinate.storage.redis.lock;

import com.jef.transaction.common.executor.Initialize;
import com.jef.transaction.common.loader.LoadLevel;
import com.jef.transaction.common.util.CollectionUtils;
import com.jef.transaction.coordinate.lock.AbstractLockManager;
import com.jef.transaction.coordinate.session.BranchSession;
import com.jef.transaction.coordinate.session.GlobalSession;
import com.jef.transaction.core.exception.TransactionException;
import com.jef.transaction.core.lock.Locker;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author funkye
 */
@LoadLevel(name = "redis")
public class RedisLockManager extends AbstractLockManager implements Initialize {

    /**
     * The locker.
     */
    private Locker locker;

    @Override
    public void init() {
        locker = new RedisLocker();
    }

    @Override
    public Locker getLocker(BranchSession branchSession) {
        return locker;
    }

    @Override
    public boolean releaseLock(BranchSession branchSession) throws TransactionException {
        try {
            return getLocker().releaseLock(branchSession.getXid(), branchSession.getBranchId());
        } catch (Exception t) {
            LOGGER.error("unLock error, xid {}, branchId:{}", branchSession.getXid(), branchSession.getBranchId(), t);
            return false;
        }
    }

    @Override
    public boolean releaseGlobalSessionLock(GlobalSession globalSession) throws TransactionException {
        List<BranchSession> branchSessions = globalSession.getBranchSessions();
        if (CollectionUtils.isEmpty(branchSessions)) {
            return true;
        }
        List<Long> branchIds = branchSessions.stream().map(BranchSession::getBranchId).collect(Collectors.toList());
        try {
            return getLocker().releaseLock(globalSession.getXid(), branchIds);
        } catch (Exception t) {
            LOGGER.error("unLock globalSession error, xid:{} branchIds:{}", globalSession.getXid(),
                    CollectionUtils.toString(branchIds), t);
            return false;
        }
    }
}