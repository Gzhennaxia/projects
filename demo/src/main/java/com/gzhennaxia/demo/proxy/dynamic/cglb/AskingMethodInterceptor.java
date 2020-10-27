package com.gzhennaxia.demo.proxy.dynamic.cglb;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author bo li
 * @date 2020-10-27 13:53
 */
public class AskingMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = methodProxy.invokeSuper(o, objects);
        if (method.getName().equals("askForPay"))
            System.out.println("如果不还将承担法律责任！");
        return result;
    }
}
