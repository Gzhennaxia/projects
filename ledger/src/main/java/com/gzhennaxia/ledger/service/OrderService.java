package com.gzhennaxia.ledger.service;

import java.io.File;

/**
 * @author bo li
 * @date 2020-07-22 12:08
 */
public interface OrderService {

    void saveWeChatOrders(File file);

    void saveWeChatOrders(String filePath);
}
