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
package com.jef.transaction.coordinate.storage.file.lock;

import com.jef.transaction.common.loader.LoadLevel;
import com.jef.transaction.coordinate.lock.AbstractLockManager;
import com.jef.transaction.coordinate.session.BranchSession;
import com.jef.transaction.coordinate.session.GlobalSession;
import com.jef.transaction.core.exception.TransactionException;
import com.jef.transaction.core.lock.Locker;
import org.slf4j.MDC;

import java.util.ArrayList;

import static com.jef.transaction.core.context.RootContext.MDC_KEY_BRANCH_ID;


/**
 * The type file lock manager.
 *
 * @author zhangsen
 */
@LoadLevel(name = "file")
public class FileLockManager extends AbstractLockManager {

    @Override
    public Locker getLocker(BranchSession branchSession) {
        return new FileLocker(branchSession);
    }

    @Override
    public boolean releaseGlobalSessionLock(GlobalSession globalSession) throws TransactionException {
        ArrayList<BranchSession> branchSessions = globalSession.getBranchSessions();
        boolean releaseLockResult = true;
        for (BranchSession branchSession : branchSessions) {
            try {
                MDC.put(MDC_KEY_BRANCH_ID, String.valueOf(branchSession.getBranchId()));
                if (!this.releaseLock(branchSession)) {
                    releaseLockResult = false;
                }
            } finally {
                MDC.remove(MDC_KEY_BRANCH_ID);
            }
        }
        return releaseLockResult;
    }

}
