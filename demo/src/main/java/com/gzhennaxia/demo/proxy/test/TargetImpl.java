package com.gzhennaxia.demo.proxy.test;

/**
 * @author bo li
 * @date 2020-12-07 12:25
 */
public class TargetImpl implements Target {

    @Override
    public int test(int i) {
        return i + 1;
    }
}