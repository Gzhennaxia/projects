package com.gzhennaxia.demo.design_pattern.registry.impl2;

import com.gzhennaxia.demo.design_pattern.registry.CashNormal;
import com.gzhennaxia.demo.design_pattern.registry.CashRebate;
import com.gzhennaxia.demo.design_pattern.registry.CashReturn;
import com.gzhennaxia.demo.design_pattern.registry.CashSuper;

/**
 * @author bo li
 * @date 2020-12-02 14:52
 */
public class CashContext {

    private CashSuper cashSuper;

    public CashContext(String type) {
        CashSuper cashSuper = null;
        switch (type) {
            case "正常收费":
                cashSuper = new CashNormal();
                break;
            case "满300减100":
                cashSuper = new CashReturn(300, 100);
                break;
            case "打8折":
                cashSuper = new CashRebate(0.8);
                break;
            default:
                break;
        }
        this.cashSuper = cashSuper;
    }

    public double getResult(double money) {
        return cashSuper.acceptCash(money);
    }
}
