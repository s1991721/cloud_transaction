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
package com.jef.transaction.starter;

import com.jef.transaction.config.springcloud.SpringApplicationContextProvider;
import com.jef.transaction.starter.properties.SeataProperties;
import com.jef.transaction.starter.properties.client.*;
import com.jef.transaction.starter.properties.config.*;
import com.jef.transaction.starter.properties.registry.*;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import static com.jef.transaction.common.Constants.BEAN_NAME_SPRING_APPLICATION_CONTEXT_PROVIDER;
import static com.jef.transaction.starter.StarterConstants.*;

/**
 * The type Seata properties auto configuration
 *
 * @author xingfudeshi@gmail.com
 */
@ConditionalOnProperty(prefix = SEATA_PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
@ComponentScan(basePackages = "com.jef.transaction.starter.properties")
@AutoConfigureBefore({SeataAutoConfiguration.class, SeataDataSourceAutoConfiguration.class})
public class SeataPropertiesAutoConfiguration {
    static {

        PROPERTY_BEAN_MAP.put(SEATA_PREFIX, SeataProperties.class);

        PROPERTY_BEAN_MAP.put(CLIENT_RM_PREFIX, RmProperties.class);
        PROPERTY_BEAN_MAP.put(CLIENT_TM_PREFIX, TmProperties.class);
        PROPERTY_BEAN_MAP.put(LOCK_PREFIX, LockProperties.class);
        PROPERTY_BEAN_MAP.put(SERVICE_PREFIX, ServiceProperties.class);
        PROPERTY_BEAN_MAP.put(SHUTDOWN_PREFIX, ShutdownProperties.class);
        PROPERTY_BEAN_MAP.put(THREAD_FACTORY_PREFIX, ThreadFactoryProperties.class);
        PROPERTY_BEAN_MAP.put(UNDO_PREFIX, UndoProperties.class);
        PROPERTY_BEAN_MAP.put(COMPRESS_PREFIX, UndoCompressProperties.class);
        PROPERTY_BEAN_MAP.put(LOG_PREFIX, LogProperties.class);
        PROPERTY_BEAN_MAP.put(TRANSPORT_PREFIX, TransportProperties.class);
        PROPERTY_BEAN_MAP.put(CONFIG_PREFIX, ConfigProperties.class);
        PROPERTY_BEAN_MAP.put(CONFIG_FILE_PREFIX, ConfigFileProperties.class);
        PROPERTY_BEAN_MAP.put(REGISTRY_PREFIX, RegistryProperties.class);
        PROPERTY_BEAN_MAP.put(LOAD_BALANCE_PREFIX, LoadBalanceProperties.class);

        PROPERTY_BEAN_MAP.put(CONFIG_NACOS_PREFIX, ConfigNacosProperties.class);
        PROPERTY_BEAN_MAP.put(CONFIG_CONSUL_PREFIX, ConfigConsulProperties.class);
        PROPERTY_BEAN_MAP.put(CONFIG_ZK_PREFIX, ConfigZooKeeperProperties.class);
        PROPERTY_BEAN_MAP.put(CONFIG_APOLLO_PREFIX, ConfigApolloProperties.class);
        PROPERTY_BEAN_MAP.put(CONFIG_ETCD3_PREFIX, ConfigEtcd3Properties.class);
        PROPERTY_BEAN_MAP.put(CONFIG_CUSTOM_PREFIX, ConfigCustomProperties.class);

        PROPERTY_BEAN_MAP.put(REGISTRY_CONSUL_PREFIX, RegistryConsulProperties.class);
        PROPERTY_BEAN_MAP.put(REGISTRY_ETCD3_PREFIX, RegistryEtcd3Properties.class);
        PROPERTY_BEAN_MAP.put(REGISTRY_EUREKA_PREFIX, RegistryEurekaProperties.class);
        PROPERTY_BEAN_MAP.put(REGISTRY_NACOS_PREFIX, RegistryNacosProperties.class);
        PROPERTY_BEAN_MAP.put(REGISTRY_REDIS_PREFIX, RegistryRedisProperties.class);
        PROPERTY_BEAN_MAP.put(REGISTRY_SOFA_PREFIX, RegistrySofaProperties.class);
        PROPERTY_BEAN_MAP.put(REGISTRY_ZK_PREFIX, RegistryZooKeeperProperties.class);
        PROPERTY_BEAN_MAP.put(REGISTRY_CUSTOM_PREFIX, RegistryCustomProperties.class);

    }

    @Bean(BEAN_NAME_SPRING_APPLICATION_CONTEXT_PROVIDER)
    @ConditionalOnMissingBean(name = {BEAN_NAME_SPRING_APPLICATION_CONTEXT_PROVIDER})
    public SpringApplicationContextProvider springApplicationContextProvider() {
        return new SpringApplicationContextProvider();
    }
}
