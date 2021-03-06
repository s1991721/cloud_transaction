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

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author xingfudeshi@gmail.com
 * This annotation will enable auto proxying of datasource bean.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AutoDataSourceProxyRegistrar.class)
@Documented
public @interface EnableAutoDataSourceProxy {
    /**
     * Whether use JDK proxy instead of CGLIB proxy
     *
     * @return useJdkProxy
     */
    boolean useJdkProxy() default false;

    /**
     * Specifies which datasource bean are not eligible for auto-proxying
     *
     * @return excludes
     */
    String[] excludes() default {};

    /**
     * Data source proxy mode, AT or XA
     *
     * @return dataSourceProxyMode
     */
    String dataSourceProxyMode() default "AT";
}
