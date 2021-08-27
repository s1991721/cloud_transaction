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
package com.jef.transaction.tcc.remoting.parser;

import com.jef.transaction.common.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * dubbo attribute analysis
 *
 * @author zhangsen
 */
public class DubboUtil {

    private DubboUtil() {

    }

    private static final String ALIBABA_DUBBO_PROXY_NAME_PREFIX = "com.alibaba.dubbo.common.bytecode.proxy";
    private static final String APACHE_DUBBO_PROXY_NAME_PREFIX = "org.apache.dubbo.common.bytecode.proxy";

    /**
     * get the interface class of the dubbo proxy which be  generated by javaassist
     *
     * @param proxyBean the proxy bean
     * @return the assist interface
     * @throws NoSuchFieldException the no such field exception
     * @throws SecurityException the security exception
     * @throws IllegalArgumentException the illegal argument exception
     * @throws IllegalAccessException the illegal access exception
     * @throws NoSuchMethodException the no such method exception
     * @throws InvocationTargetException the invocation target exception
     */
    public static Class<?> getAssistInterface(Object proxyBean)
        throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
        NoSuchMethodException, InvocationTargetException {
        if (proxyBean == null) {
            return null;
        }
        if (!isDubboProxyName(proxyBean.getClass().getName())) {
            return null;
        }
        Field handlerField = proxyBean.getClass().getDeclaredField("handler");
        handlerField.setAccessible(true);
        Object invokerInvocationHandler = handlerField.get(proxyBean);
        Field invokerField = invokerInvocationHandler.getClass().getDeclaredField("invoker");
        invokerField.setAccessible(true);
        Object invoker = invokerField.get(invokerInvocationHandler);
        Field failoverClusterInvokerField = invoker.getClass().getDeclaredField("invoker");
        failoverClusterInvokerField.setAccessible(true);
        Object failoverClusterInvoker = failoverClusterInvokerField.get(invoker);
        return (Class<?>)ReflectionUtil.invokeMethod(failoverClusterInvoker,
            "getInterface");
    }

    public static boolean isDubboProxyName(String name) {
        return name.startsWith(ALIBABA_DUBBO_PROXY_NAME_PREFIX) || name.startsWith(APACHE_DUBBO_PROXY_NAME_PREFIX);
    }
}
