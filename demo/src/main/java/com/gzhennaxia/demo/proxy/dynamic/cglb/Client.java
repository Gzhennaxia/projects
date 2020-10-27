package com.gzhennaxia.demo.proxy.dynamic.cglb;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author bo li
 * @date 2020-10-27 13:55
 */
public class Client {

    public static void main(String[] args) {
        Employee employee = new Employee();
        Employee proxy = (Employee) Enhancer.create(employee.getClass(), new AskingMethodInterceptor());

        proxy.askForPay();
    }
}
