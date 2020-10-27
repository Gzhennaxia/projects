package com.gzhennaxia.demo.proxy;

/**
 * @author bo li
 * @date 2020-10-27 11:13
 */
public class Lawyer implements AskAbility {
    private Employee employee;

    public Lawyer(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void askForPay() {
        employee.askForPay();
        System.out.println("如果不还将承担法律责任！");
    }
}
