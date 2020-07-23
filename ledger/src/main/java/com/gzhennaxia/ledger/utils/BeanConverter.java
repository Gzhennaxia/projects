package com.gzhennaxia.ledger.utils;

import com.gzhennaxia.common.utils.DateUtils;
import com.gzhennaxia.ledger.entity.Order;
import com.gzhennaxia.ledger.entity.WeChatLedgerItem;
import org.apache.commons.csv.CSVRecord;

import java.util.Date;

/**
 * @author bo li
 * @date 2020-07-22 13:42
 */
public class BeanConverter {

    public static WeChatLedgerItem convert2WeChatLedgerItem(CSVRecord record) {
        WeChatLedgerItem ret = null;
        Date date = DateUtils.parse(record.get(0));
        if (date != null) {
            ret = new WeChatLedgerItem();
            ret.setTransactionTime(DateUtils.parse(record.get(0)));
            ret.setTransactionType(record.get(1));
            ret.setCounterparty(record.get(2));
            ret.setProductName(record.get(3));
            ret.setIncomeOrExpenditure(record.get(4));
            ret.setMoney(record.get(5));
            ret.setPayType(record.get(6));
            ret.setStatus(record.get(7));
            ret.setTransactionNumber(record.get(8));
            ret.setMerchantNumber(record.get(9));
            ret.setRemark(record.get(10));
        }
        return ret;
    }

    public static Order convert2Order(WeChatLedgerItem weChatLedgerItem) {

        return null;
    }
}
