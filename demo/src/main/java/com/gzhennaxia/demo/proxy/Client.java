package com.gzhennaxia.demo.proxy;

/**
 * @author bo li
 * @date 2020-10-27 11:26
 */
public class Client {

    public static void main(String[] args) {
        Employee employee = new Employee();
        AskAbility ask = new Lawyer(employee);
        ask.askForPay();
    }
}
