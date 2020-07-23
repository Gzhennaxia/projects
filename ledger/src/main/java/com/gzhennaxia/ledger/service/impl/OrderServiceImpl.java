package com.gzhennaxia.ledger.service.impl;

import com.gzhennaxia.ledger.entity.Order;
import com.gzhennaxia.ledger.entity.OrderItem;
import com.gzhennaxia.ledger.entity.WeChatLedgerItem;
import com.gzhennaxia.ledger.service.OrderService;
import com.gzhennaxia.ledger.utils.BeanConverter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author bo li
 * @date 2020-07-22 12:08
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public void saveWeChatOrders(File file) {

    }

    @Override
    public void saveWeChatOrders(String filePath) {
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(filePath));
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord record : parser) {
                WeChatLedgerItem item = BeanConverter.convert2WeChatLedgerItem(record);
                if (item != null) {
                    Order order = BeanConverter.convert2Order(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
