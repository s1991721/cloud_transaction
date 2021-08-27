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
package com.jef.transaction.coordinate.transaction.tcc;

import com.jef.transaction.coordinate.coordinator.AbstractCore;
import com.jef.transaction.core.model.BranchType;
import com.jef.transaction.core.rpc.RemotingServer;

/**
 * The type tcc core.
 *
 * @author ph3636
 */
public class TccCore extends AbstractCore {

    public TccCore(RemotingServer remotingServer) {
        super(remotingServer);
    }

    @Override
    public BranchType getHandleBranchType() {
        return BranchType.TCC;
    }
}
