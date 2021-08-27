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
package com.jef.transaction.datasource.datasource.undo.mysql;

import com.jef.transaction.common.loader.LoadLevel;
import com.jef.transaction.datasource.datasource.undo.AbstractUndoExecutor;
import com.jef.transaction.datasource.datasource.undo.SQLUndoLog;
import com.jef.transaction.datasource.datasource.undo.UndoExecutorHolder;
import com.jef.transaction.sqlparser.core.util.JdbcConstants;

/**
 * The Type MySQLUndoExecutorHolder
 *
 * @author: Zhibei Hao
 */
@LoadLevel(name = JdbcConstants.MYSQL)
public class MySQLUndoExecutorHolder implements UndoExecutorHolder {

    @Override
    public AbstractUndoExecutor getInsertExecutor(SQLUndoLog sqlUndoLog) {
        return new MySQLUndoInsertExecutor(sqlUndoLog);
    }

    @Override
    public AbstractUndoExecutor getUpdateExecutor(SQLUndoLog sqlUndoLog) {
        return new MySQLUndoUpdateExecutor(sqlUndoLog);
    }

    @Override
    public AbstractUndoExecutor getDeleteExecutor(SQLUndoLog sqlUndoLog) {
        return new MySQLUndoDeleteExecutor(sqlUndoLog);
    }
}
