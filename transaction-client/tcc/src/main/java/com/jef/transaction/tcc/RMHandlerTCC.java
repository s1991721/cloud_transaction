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
package com.jef.transaction.tcc;

import com.jef.transaction.core.model.BranchType;
import com.jef.transaction.core.model.ResourceManager;
import com.jef.transaction.core.protocol.transaction.UndoLogDeleteRequest;
import com.jef.transaction.rm.AbstractRMHandler;
import com.jef.transaction.rm.DefaultResourceManager;

/**
 * The type Rm handler tcc.
 *
 * @author zhangsen
 */
public class RMHandlerTCC extends AbstractRMHandler {

    @Override
    public void handle(UndoLogDeleteRequest request) {
        //DO nothing
    }

    @Override
    protected ResourceManager getResourceManager() {
        return DefaultResourceManager.get().getResourceManager(BranchType.TCC);
    }

    @Override
    public BranchType getBranchType() {
        return BranchType.TCC;
    }

}
