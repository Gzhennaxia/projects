package com.gzhennaxia.demo.design_pattern.registry.impl1;

import com.gzhennaxia.demo.design_pattern.registry.CashSuper;

/**
 * @author bo li
 * @date 2020-12-02 14:38
 */
public class Client {

    private final static double MONEY = 1000;

    public static void main(String[] args) {
        CashSuper cashSuper = CashFactory.createCashAccept("正常收费");
        System.out.println("Primary money="+MONEY+", Final money="+cashSuper.acceptCash(MONEY));

        CashSuper cashSuper2 = CashFactory.createCashAccept("满300减100");
        System.out.println("Primary money="+MONEY+", Final money="+cashSuper2.acceptCash(MONEY));

        CashSuper cashSuper3 = CashFactory.createCashAccept("打8折");
        System.out.println("Primary money="+MONEY+", Final money="+cashSuper3.acceptCash(MONEY));
    }

}
