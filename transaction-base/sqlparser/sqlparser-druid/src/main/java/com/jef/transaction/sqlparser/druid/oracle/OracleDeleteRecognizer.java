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
package com.jef.transaction.sqlparser.druid.oracle;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.ast.statement.SQLJoinTableSource;
import com.alibaba.druid.sql.ast.statement.SQLTableSource;
import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleDeleteStatement;
import com.alibaba.druid.sql.dialect.oracle.visitor.OracleOutputVisitor;
import com.jef.transaction.common.exception.NotSupportYetException;
import com.jef.transaction.sqlparser.core.ParametersHolder;
import com.jef.transaction.sqlparser.core.SQLDeleteRecognizer;
import com.jef.transaction.sqlparser.core.SQLType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type oracle delete recognizer.
 *
 * @author ccg
 */
public class OracleDeleteRecognizer extends BaseOracleRecognizer implements SQLDeleteRecognizer {

    private final OracleDeleteStatement ast;

    /**
     * Instantiates a new My sql delete recognizer.
     *
     * @param originalSQL the original sql
     * @param ast         the ast
     */
    public OracleDeleteRecognizer(String originalSQL, SQLStatement ast) {
        super(originalSQL);
        this.ast = (OracleDeleteStatement)ast;
    }

    @Override
    public SQLType getSQLType() {
        return SQLType.DELETE;
    }

    @Override
    public String getTableAlias() {
        return ast.getTableSource().getAlias();
    }

    @Override
    public String getTableName() {
        StringBuilder sb = new StringBuilder();
        OracleOutputVisitor visitor = new OracleOutputVisitor(sb) {

            @Override
            public boolean visit(SQLExprTableSource x) {
                printTableSourceExpr(x.getExpr());
                return false;
            }

            @Override
            public boolean visit(SQLJoinTableSource x) {
                throw new NotSupportYetException("not support the syntax of delete with join table");
            }
        };
        SQLTableSource tableSource;
        if (ast.getFrom() == null) {
            tableSource = ast.getTableSource();
        } else {
            tableSource = ast.getFrom();
        }

        if (tableSource instanceof SQLExprTableSource) {
            visitor.visit((SQLExprTableSource) tableSource);
        } else if (tableSource instanceof SQLJoinTableSource) {
            visitor.visit((SQLJoinTableSource) tableSource);
        } else {
            throw new NotSupportYetException("not support the syntax of delete with unknow");
        }
        return sb.toString();
    }

    @Override
    public String getWhereCondition(final ParametersHolder parametersHolder,
        final ArrayList<List<Object>> paramAppenderList) {
        SQLExpr where = ast.getWhere();
        return super.getWhereCondition(where, parametersHolder, paramAppenderList);
    }

    @Override
    public String getWhereCondition() {
        SQLExpr where = ast.getWhere();
        return super.getWhereCondition(where);
    }

}
