package com.gzhennaxia.demo.design_pattern.registry;

/**
 * 返利/满减收费子类
 *
 * @author bo li
 * @date 2020-12-02 14:26
 */
public class CashReturn implements CashSuper {

    private double moneyCondition;

    private double moneyReturn;

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    /**
     * e.g. 每满 300 减 100，满 600 就减 200
     *
     * @author bli@skystartrade.com
     * @date 2020-12-02 14:29
     */
    @Override
    public double acceptCash(double money) {
        if (money > moneyCondition) {
            money -= (int) (money / moneyCondition) * moneyReturn;
        }
        return money;
    }
}
