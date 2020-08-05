package com.gzhennaxia.ledger.utils;

import com.gzhennaxia.common.utils.DateUtils;
import com.gzhennaxia.ledger.entity.AliPayLedgerItem;
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

    public static AliPayLedgerItem convert2AliPayLedgerItem(CSVRecord record) {
        AliPayLedgerItem ret = null;
        if (record.size() >= 16 && !record.get(0).startsWith("交易号")) {
            ret = new AliPayLedgerItem();
            ret.setTransactionNumber(record.get(0).trim());
            ret.setMerchantOrderId(record.get(1).trim());
            ret.setDealCreateTime(DateUtils.parse(record.get(2).trim()));
            ret.setPayTime(DateUtils.parse(record.get(3).trim()));
            ret.setLastUpdateTime(DateUtils.parse(record.get(4).trim()));
            ret.setDealSource(record.get(5).trim());
            ret.setType(record.get(6).trim());
            ret.setCounterparty(record.get(7).trim());
            ret.setProductName(record.get(8).trim());
            ret.setMoney(record.get(9).trim());
            ret.setIncomeOrExpenditure(record.get(10).trim());
            ret.setStatus(record.get(11).trim());
            ret.setServiceFee(record.get(12).trim());
            ret.setRefundMoney(record.get(13).trim());
            ret.setRemark(record.get(14).trim());
            ret.setFundStatus(record.get(15).trim());
        }
        return ret;
    }

    public static Order convert2Order(WeChatLedgerItem weChatLedgerItem) {

        return null;
    }
}
