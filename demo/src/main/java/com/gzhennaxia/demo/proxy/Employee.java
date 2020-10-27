package com.gzhennaxia.demo.proxy;

/**
 * @author bo li
 * @date 2020-10-27 11:12
 */
public class Employee implements AskAbility {
    @Override
    public void askForPay() {
        System.out.println("还钱！");
    }
}
