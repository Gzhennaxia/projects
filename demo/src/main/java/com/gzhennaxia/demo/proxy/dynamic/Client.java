package com.gzhennaxia.demo.proxy.dynamic;

import com.gzhennaxia.demo.proxy.AskAbility;
import com.gzhennaxia.demo.proxy.Employee;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author bo li
 * @date 2020-10-27 11:56
 */
public class Client {

    public static void main(String[] args) {
        Employee employee = new Employee();
        InvocationHandler handler = new AskingHandler(employee);
        AskAbility proxy = (AskAbility) Proxy.newProxyInstance(employee.getClass().getClassLoader(), employee.getClass().getInterfaces(), handler);
        proxy.askForPay();
    }
}
