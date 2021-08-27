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
package com.jef.transaction.datasource.datasource.undo.oracle;

import com.jef.transaction.common.exception.ShouldNeverHappenException;
import com.jef.transaction.common.util.CollectionUtils;
import com.jef.transaction.datasource.datasource.ColumnUtils;
import com.jef.transaction.datasource.datasource.sql.struct.Field;
import com.jef.transaction.datasource.datasource.sql.struct.Row;
import com.jef.transaction.datasource.datasource.sql.struct.TableRecords;
import com.jef.transaction.datasource.datasource.undo.AbstractUndoExecutor;
import com.jef.transaction.datasource.datasource.undo.SQLUndoLog;
import com.jef.transaction.sqlparser.core.util.JdbcConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type oracle undo delete executor.
 *
 * @author ccg
 */
public class OracleUndoDeleteExecutor extends AbstractUndoExecutor {

    /**
     * INSERT INTO a (x, y, z, pk) VALUES (?, ?, ?, ?)
     */
    private static final String INSERT_SQL_TEMPLATE = "INSERT INTO %s (%s) VALUES (%s)";

    /**
     * Instantiates a new oracle undo delete executor.
     *
     * @param sqlUndoLog the sql undo log
     */
    public OracleUndoDeleteExecutor(SQLUndoLog sqlUndoLog) {
        super(sqlUndoLog);
    }

    @Override
    protected String buildUndoSQL() {
        TableRecords beforeImage = sqlUndoLog.getBeforeImage();
        List<Row> beforeImageRows = beforeImage.getRows();
        if (CollectionUtils.isEmpty(beforeImageRows)) {
            throw new ShouldNeverHappenException("Invalid UNDO LOG");
        }
        Row row = beforeImageRows.get(0);
        List<Field> fields = new ArrayList<>(row.nonPrimaryKeys());
        fields.addAll(getOrderedPkList(beforeImage,row, JdbcConstants.ORACLE));

        // delete sql undo log before image all field come from table meta, need add escape.
        // see BaseTransactionalExecutor#buildTableRecords
        String insertColumns = fields.stream()
            .map(field -> ColumnUtils.addEscape(field.getName(), JdbcConstants.ORACLE))
            .collect(Collectors.joining(", "));
        String insertValues = fields.stream().map(field -> "?")
            .collect(Collectors.joining(", "));

        return String.format(INSERT_SQL_TEMPLATE, sqlUndoLog.getTableName(), insertColumns, insertValues);
    }

    @Override
    protected TableRecords getUndoRows() {
        return sqlUndoLog.getBeforeImage();
    }
}
