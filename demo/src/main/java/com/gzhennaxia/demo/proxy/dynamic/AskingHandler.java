package com.gzhennaxia.demo.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author bo li
 * @date 2020-10-27 11:52
 */
public class AskingHandler implements InvocationHandler {

    private Object target;

    public AskingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(target, args);
        System.out.println("如果不还将承担法律责任！");
        return invoke;
    }
}
