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
package com.jef.transaction.datasource.datasource.exec;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.jef.transaction.common.util.StringUtils;
import com.jef.transaction.datasource.datasource.ColumnUtils;
import com.jef.transaction.datasource.datasource.StatementProxy;
import com.jef.transaction.datasource.datasource.sql.struct.TableMeta;
import com.jef.transaction.datasource.datasource.sql.struct.TableRecords;
import com.jef.transaction.sqlparser.core.ParametersHolder;
import com.jef.transaction.sqlparser.core.SQLDeleteRecognizer;
import com.jef.transaction.sqlparser.core.SQLRecognizer;

/**
 * The type Delete executor.
 *
 * @author sharajava
 *
 * @param <T> the type parameter
 * @param <S> the type parameter
 */
public class DeleteExecutor<T, S extends Statement> extends AbstractDMLBaseExecutor<T, S> {

    /**
     * Instantiates a new Delete executor.
     *
     * @param statementProxy    the statement proxy
     * @param statementCallback the statement callback
     * @param sqlRecognizer     the sql recognizer
     */
    public DeleteExecutor(StatementProxy<S> statementProxy, StatementCallback<T,S> statementCallback,
                          SQLRecognizer sqlRecognizer) {
        super(statementProxy, statementCallback, sqlRecognizer);
    }

    @Override
    protected TableRecords beforeImage() throws SQLException {
        SQLDeleteRecognizer visitor = (SQLDeleteRecognizer) sqlRecognizer;
        TableMeta tmeta = getTableMeta(visitor.getTableName());
        ArrayList<List<Object>> paramAppenderList = new ArrayList<>();
        String selectSQL = buildBeforeImageSQL(visitor, tmeta, paramAppenderList);
        return buildTableRecords(tmeta, selectSQL, paramAppenderList);
    }

    private String buildBeforeImageSQL(SQLDeleteRecognizer visitor, TableMeta tableMeta, ArrayList<List<Object>> paramAppenderList) {
        String whereCondition = buildWhereCondition(visitor, paramAppenderList);
        StringBuilder suffix = new StringBuilder(" FROM ").append(getFromTableInSQL());
        if (StringUtils.isNotBlank(whereCondition)) {
            suffix.append(WHERE).append(whereCondition);
        }
        String orderBy = visitor.getOrderBy();
        if (StringUtils.isNotBlank(orderBy)) {
            suffix.append(orderBy);
        }
        ParametersHolder parametersHolder = statementProxy instanceof ParametersHolder ? (ParametersHolder)statementProxy : null;
        String limit = visitor.getLimit(parametersHolder, paramAppenderList);
        if (StringUtils.isNotBlank(limit)) {
            suffix.append(limit);
        }
        suffix.append(" FOR UPDATE");
        StringJoiner selectSQLAppender = new StringJoiner(", ", "SELECT ", suffix.toString());
        for (String column : tableMeta.getAllColumns().keySet()) {
            selectSQLAppender.add(getColumnNameInSQL(ColumnUtils.addEscape(column, getDbType())));
        }
        return selectSQLAppender.toString();
    }

    @Override
    protected TableRecords afterImage(TableRecords beforeImage) throws SQLException {
        return TableRecords.empty(getTableMeta());
    }
}
