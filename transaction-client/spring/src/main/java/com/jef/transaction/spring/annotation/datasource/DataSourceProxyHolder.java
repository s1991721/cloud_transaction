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
package com.jef.transaction.spring.annotation.datasource;

import com.jef.transaction.core.model.BranchType;
import com.jef.transaction.datasource.datasource.DataSourceProxy;
import com.jef.transaction.datasource.datasource.SeataDataSourceProxy;
import com.jef.transaction.datasource.datasource.xa.DataSourceProxyXA;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * the type data source proxy holder
 *
 * @author xingfudeshi@gmail.com
 */
public class DataSourceProxyHolder {
    private static final int MAP_INITIAL_CAPACITY = 8;
    private Map<DataSource, SeataDataSourceProxy> dataSourceProxyMap;

    private DataSourceProxyHolder() {
        dataSourceProxyMap = new HashMap<>(MAP_INITIAL_CAPACITY);
    }

    /**
     * the type holder
     */
    private static class Holder {
        private static final DataSourceProxyHolder INSTANCE;

        static {
            INSTANCE = new DataSourceProxyHolder();
        }
    }

    /**
     * Get DataSourceProxyHolder instance
     *
     * @return the INSTANCE of DataSourceProxyHolder
     */
    public static DataSourceProxyHolder get() {
        return Holder.INSTANCE;
    }

    /**
     * Put dataSource
     *
     * @param dataSource          the data source
     * @param dataSourceProxyMode the data source proxy mode
     * @return dataSourceProxy
     */
    public SeataDataSourceProxy putDataSource(DataSource dataSource, BranchType dataSourceProxyMode) {
        DataSource originalDataSource;
        if (dataSource instanceof SeataDataSourceProxy) {
            SeataDataSourceProxy dataSourceProxy = (SeataDataSourceProxy) dataSource;

            //If it's an right proxy, return it directly.
            if (dataSourceProxyMode == dataSourceProxy.getBranchType()) {
                return (SeataDataSourceProxy) dataSource;
            }

            //Get the original data source.
            originalDataSource = dataSourceProxy.getTargetDataSource();
        } else {
            originalDataSource = dataSource;
        }

        SeataDataSourceProxy dsProxy = dataSourceProxyMap.get(originalDataSource);
        if (dsProxy == null) {
            synchronized (dataSourceProxyMap) {
                dsProxy = dataSourceProxyMap.get(originalDataSource);
                if (dsProxy == null) {
                    dsProxy = createDsProxyByMode(dataSourceProxyMode, originalDataSource);
                    dataSourceProxyMap.put(originalDataSource, dsProxy);
                }
            }
        }
        return dsProxy;
    }

    private SeataDataSourceProxy createDsProxyByMode(BranchType mode, DataSource originDs) {
        return BranchType.XA == mode ? new DataSourceProxyXA(originDs) : new DataSourceProxy(originDs);
    }
}
