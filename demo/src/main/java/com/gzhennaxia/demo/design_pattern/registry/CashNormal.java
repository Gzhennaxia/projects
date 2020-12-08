package com.gzhennaxia.demo.design_pattern.registry;

/**
 * @author bo li
 * @date 2020-12-02 14:19
 */
public class CashNormal implements CashSuper{
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
