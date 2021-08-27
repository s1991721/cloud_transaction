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
package com.jef.transaction.datasource.datasource.undo.postgresql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jef.transaction.common.exception.ShouldNeverHappenException;
import com.jef.transaction.common.util.CollectionUtils;
import com.jef.transaction.datasource.datasource.SqlGenerateUtils;
import com.jef.transaction.datasource.datasource.sql.struct.Field;
import com.jef.transaction.datasource.datasource.sql.struct.Row;
import com.jef.transaction.datasource.datasource.sql.struct.TableRecords;
import com.jef.transaction.datasource.datasource.undo.AbstractUndoExecutor;
import com.jef.transaction.datasource.datasource.undo.SQLUndoLog;
import com.jef.transaction.sqlparser.core.util.JdbcConstants;

/**
 * The type postgresql undo insert executor.
 *
 * @author japsercloud
 */
public class PostgresqlUndoInsertExecutor extends AbstractUndoExecutor {

    /**
     * DELETE FROM a WHERE pk = ?
     */
    private static final String DELETE_SQL_TEMPLATE = "DELETE FROM %s WHERE %s ";

    @Override
    protected String buildUndoSQL() {
        TableRecords afterImage = sqlUndoLog.getAfterImage();
        List<Row> afterImageRows = afterImage.getRows();
        if (CollectionUtils.isEmpty(afterImageRows)) {
            throw new ShouldNeverHappenException("Invalid UNDO LOG");
        }
        return generateDeleteSql(afterImageRows,afterImage);
    }

    @Override
    protected void undoPrepare(PreparedStatement undoPST, ArrayList<Field> undoValues, List<Field> pkValueList) throws SQLException {
        int undoIndex = 0;
        for (Field pkField:pkValueList) {
            undoIndex++;
            undoPST.setObject(undoIndex, pkField.getValue(), pkField.getType());
        }
    }

    private String generateDeleteSql(List<Row> rows, TableRecords afterImage) {
        List<String> pkNameList = getOrderedPkList(afterImage, rows.get(0), JdbcConstants.POSTGRESQL).stream().map(
            e -> e.getName()).collect(Collectors.toList());
        String whereSql = SqlGenerateUtils.buildWhereConditionByPKs(pkNameList, JdbcConstants.POSTGRESQL);
        return String.format(DELETE_SQL_TEMPLATE, sqlUndoLog.getTableName(), whereSql);
    }

    /**
     * Instantiates a new postgresql undo insert executor.
     *
     * @param sqlUndoLog the sql undo log
     */
    public PostgresqlUndoInsertExecutor(SQLUndoLog sqlUndoLog) {
        super(sqlUndoLog);
    }

    @Override
    protected TableRecords getUndoRows() {
        return sqlUndoLog.getAfterImage();
    }
}
