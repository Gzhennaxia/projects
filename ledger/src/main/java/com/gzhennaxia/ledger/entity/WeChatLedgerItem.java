package com.gzhennaxia.ledger.entity;

import com.gzhennaxia.common.utils.DateUtils;
import lombok.Data;
import org.apache.commons.csv.CSVRecord;

import java.util.Date;

/**
 * @author bo li
 * @date 2020-07-22 11:13
 */
@Data
public class WeChatLedgerItem {

    /**
     * 交易时间
     */
    private Date transactionTime;

    /**
     * 交易类型
     */
    private String transactionType;

    /**
     * 交易对方
     */
    private String counterparty;

    /**
     * 商品
     */
    private String productName;

    /**
     * 收/支
     */
    private String incomeOrExpenditure;

    /**
     * 金额(元)
     */
    private String money;

    /**
     * 支付方式
     */
    private String payType;

    /**
     * 当前状态
     */
    private String status;

    /**
     * 交易单号
     */
    private String transactionNumber;

    /**
     * 商户单号
     */
    private String merchantNumber;

    /**
     * 备注
     */
    private String remark;

    public WeChatLedgerItem() {

    }

    public WeChatLedgerItem(CSVRecord record) throws Exception {
        transactionTime = DateUtils.parse(record.get(0));
        transactionType = record.get(1);
        counterparty = record.get(2);
        productName = record.get(3);
        incomeOrExpenditure = record.get(4);
        money = record.get(5);
        payType = record.get(6);
        status = record.get(7);
        transactionNumber = record.get(8);
        merchantNumber = record.get(9);
        remark = record.get(10);
    }
}
