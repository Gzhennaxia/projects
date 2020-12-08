package com.gzhennaxia.ledger.demo.apache.commons.csv;

/**
 * @author bo li
 * @date 2020-12-08 17:23
 */
public class CSVUtils {
    public static String getThreeMeals(int hour) {
        String category;
        if (5 < hour && hour <= 10) {
            category = "早餐";
        } else if (10 < hour && hour <= 13) {
            category = "午餐";
        } else if (13 < hour && hour <= 19) {
            category = "晚餐";
        } else {
            category = "夜宵";
        }
        return category;
    }
}
