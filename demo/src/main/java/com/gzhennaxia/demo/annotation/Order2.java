package com.gzhennaxia.demo.annotation;

import org.springframework.stereotype.Component;

/**
 * @author bo li
 * @date 2020-10-28 10:17
 */
@org.springframework.core.annotation.Order(1)
@Component
public class Order {

    public Order() {
        System.out.println("@org.springframework.core.annotation.Order(1)");
    }
}
