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
package com.jef.transaction.sqlparser.antlr.mysql;

import com.jef.transaction.sqlparser.antlr.mysql.listener.SelectSpecificationSqlListener;
import com.jef.transaction.sqlparser.antlr.mysql.parser.MySqlLexer;
import com.jef.transaction.sqlparser.antlr.mysql.parser.MySqlParser;
import com.jef.transaction.sqlparser.antlr.mysql.stream.ANTLRNoCaseStringStream;
import com.jef.transaction.sqlparser.core.ParametersHolder;
import com.jef.transaction.sqlparser.core.SQLSelectRecognizer;
import com.jef.transaction.sqlparser.core.SQLType;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

/**
 * AntlrMySQLSelectRecognizer
 *
 * @author zhihou
 */
public class AntlrMySQLSelectRecognizer implements SQLSelectRecognizer {

    private MySqlContext sqlContext;

    public AntlrMySQLSelectRecognizer(String sql) {
        MySqlLexer mySqlLexer = new MySqlLexer(new ANTLRNoCaseStringStream(sql));
        CommonTokenStream commonTokenStream = new CommonTokenStream(mySqlLexer);
        MySqlParser parser = new MySqlParser(commonTokenStream);
        MySqlParser.RootContext root = parser.root();
        ParseTreeWalker walker = new ParseTreeWalker();
        sqlContext = new MySqlContext();
        sqlContext.setOriginalSQL(sql);
        walker.walk(new SelectSpecificationSqlListener(sqlContext), root);
    }

    @Override
    public String getWhereCondition(ParametersHolder parametersHolder, ArrayList<List<Object>> paramAppenderList) {
        return sqlContext.getWhereCondition();
    }

    @Override
    public String getWhereCondition() {
        return sqlContext.getWhereCondition();
    }

    @Override
    public SQLType getSQLType() {
        return SQLType.SELECT;
    }

    @Override
    public String getTableAlias() {
        return sqlContext.tableAlias;
    }

    @Override
    public String getTableName() {
        return sqlContext.tableName;
    }

    @Override
    public String getOriginalSQL() {
        return sqlContext.getOriginalSQL();
    }
}