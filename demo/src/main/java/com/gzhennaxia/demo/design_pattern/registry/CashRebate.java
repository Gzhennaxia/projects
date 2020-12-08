package com.gzhennaxia.demo.design_pattern.registry;

/**
 * 打折收费子类
 * <p>
 * rebate
 * 美: ['ri.beɪt]
 * 英: ['riːbeɪt]
 * n.	折扣；退还款
 * v.	削弱；给…回扣；使钝(刀刃)；〈英古〉减少
 * 网络	退款；返利；退税
 *
 * @author bo li
 * @date 2020-12-02 14:20
 */
public class CashRebate implements CashSuper {

    private double moneyRebate = 1d;

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }
}
