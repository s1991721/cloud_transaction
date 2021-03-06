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
package com.jef.transaction.core.store.db.sql.lock;

import com.jef.transaction.common.loader.LoadLevel;

/**
 * the database lock store oracle sql
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 1.2.0
 */
@LoadLevel(name = "oracle")
public class OracleLockStoreSql extends AbstractLockStoreSql {

    /**
     * The constant INSERT_LOCK_SQL_ORACLE.
     */
    private static final String INSERT_LOCK_SQL_ORACLE = "insert into " + LOCK_TABLE_PLACE_HOLD + "(" + ALL_COLUMNS + ")"
        + " values (?, ?, ?, ?, ?, ?, ?, sysdate, sysdate)";

    @Override
    public String getInsertLockSQL(String lockTable) {
        return INSERT_LOCK_SQL_ORACLE.replace(LOCK_TABLE_PLACE_HOLD, lockTable);
    }

}
