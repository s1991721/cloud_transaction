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
package com.jef.transaction.sqlparser.antlr;

import com.jef.transaction.common.loader.LoadLevel;
import com.jef.transaction.sqlparser.core.SQLParsingException;
import com.jef.transaction.sqlparser.core.SQLRecognizer;
import com.jef.transaction.sqlparser.core.SQLRecognizerFactory;
import com.jef.transaction.sqlparser.core.SqlParserType;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * @author zhihou
 */
@LoadLevel(name = SqlParserType.SQL_PARSER_TYPE_ANTLR)
public class AntlrDelegatingSQLRecognizerFactory implements SQLRecognizerFactory {

    private volatile SQLRecognizerFactory recognizerFactoryImpl;

    public AntlrDelegatingSQLRecognizerFactory() {
        setClassLoader();
    }

    /**
     * Only for unit test
     *
     */
    void setClassLoader() {
        try {
            Class<?> recognizerFactoryImplClass = ClassLoader.getSystemClassLoader().loadClass("io.seata.sqlparser.antlr.mysql.AntlrMySQLRecognizerFactory");
            Constructor<?> implConstructor = recognizerFactoryImplClass.getDeclaredConstructor();
            implConstructor.setAccessible(true);
            try {
                recognizerFactoryImpl = (SQLRecognizerFactory) implConstructor.newInstance();
            } finally {
                implConstructor.setAccessible(false);
            }
        } catch (Exception e) {
            throw new SQLParsingException(e);
        }
    }

    @Override
    public List<SQLRecognizer> create(String sql, String dbType) {
        return recognizerFactoryImpl.create(sql, dbType);
    }
}
