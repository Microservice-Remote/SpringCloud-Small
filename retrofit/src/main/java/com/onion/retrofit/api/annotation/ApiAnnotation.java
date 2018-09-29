package com.onion.retrofit.api.annotation;


import com.onion.retrofit.api.intercepter.LoggingInterceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhangqi on 2017/12/4.
 *
 * value  代表注入的baseUrl  默认是代付
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ApiAnnotation {
    String baseUrl() default "";  //baseUrl
    int[] timeOut() default {50,50,50};
    Class[] interceptor() default {LoggingInterceptor.class};
    int parseType() default Parse.JSON;  //默认Json解析
    String note() default "这是Api对象";
}
