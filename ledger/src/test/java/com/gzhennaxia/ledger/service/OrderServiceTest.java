package com.gzhennaxia.ledger.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bo li
 * @date 2020-07-22 14:30
 */
@SpringBootTest
class OrderServiceTest {


    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Test
    public void saveWeChatOrders() {
//        orderService.saveWeChatOrders("/Users/libo/Documents/GitHub/projects/ledger/src/main/java/com/gzhennaxia/ledger/demo/apache/commons/csv/微信支付账单(20200622-20200722).csv");
        orderService.saveWeChatOrders("/Users/libo/Documents/GitHub/projects/ledger/src/main/java/com/gzhennaxia/ledger/demo/apache/commons/csv/20200919-20201019.csv");
    }
}