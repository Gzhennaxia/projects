package com.gzhennaxia.demo.design_pattern.registry.impl2;

/**
 * @author bo li
 * @date 2020-12-02 14:55
 */
public class Client {
    private final static double MONEY = 1000;

    public static void main(String[] args) {
        CashContext cashContext = new CashContext("正常收费");
        System.out.println("Primary money=" + MONEY + ", Final money=" + cashContext.getResult(MONEY));

        CashContext cashContext2 = new CashContext("满300减100");
        System.out.println("Primary money=" + MONEY + ", Final money=" + cashContext2.getResult(MONEY));

        CashContext cashContext3 = new CashContext("打8折");
        System.out.println("Primary money=" + MONEY + ", Final money=" + cashContext3.getResult(MONEY));
    }
}
