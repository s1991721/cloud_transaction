package com.jef.transaction.annotation;

import java.lang.annotation.*;

/**
 * @Author: Jef
 * @Date: 2021/8/24 11:18
 * @Description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Inherited
public @interface AuthineGlobalLock {
}
