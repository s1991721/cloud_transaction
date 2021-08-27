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
package com.jef.transaction.sqlparser.antlr.mysql.visit;

import com.jef.transaction.sqlparser.antlr.mysql.MySqlContext;
import com.jef.transaction.sqlparser.antlr.mysql.parser.MySqlParser;
import com.jef.transaction.sqlparser.antlr.mysql.parser.MySqlParserBaseVisitor;

/**
 * InsertStatementSqlVisitor
 *
 * @author zhihou
 */
public class InsertStatementSqlVisitor extends MySqlParserBaseVisitor<MySqlContext> {

    private MySqlContext mySqlContext;

    public InsertStatementSqlVisitor(MySqlContext mySqlContext) {
        this.mySqlContext = mySqlContext;
    }

    @Override
    public MySqlContext visitInsertStatement(MySqlParser.InsertStatementContext ctx) {
        return new InsertSpecificationSqlVisitor(this.mySqlContext).visitInsertStatement(ctx);
    }

}