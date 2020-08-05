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
public class AliPayLedgerItem {

    /**
     * 交易号
     */
    private String transactionNumber;

    /**
     * 商家订单号
     */
    private String merchantOrderId;

    /**
     * 交易创建时间
     */
    private Date dealCreateTime;

    /**
     * 付款时间
     */
    private Date payTime;

    /**
     * 最近修改时间
     */
    private Date lastUpdateTime;

    /**
     * 交易来源地
     */
    private String dealSource;

    /**
     * 类型
     */
    private String type;


    /**
     * 交易对方
     */
    private String counterparty;

    /**
     * 商品名称
     */
    private String productName;


    /**
     * 金额(元)
     */
    private String money;

    /**
     * 收/支
     */
    private String incomeOrExpenditure;

    /**
     * 交易状态
     */
    private String status;


    /**
     * 服务费（元）
     */
    private String serviceFee;


    /**
     * 成功退款（元）
     */
    private String refundMoney;


    /**
     * 备注
     */
    private String remark;


    /**
     * 资金状态
     */
    private String fundStatus;


    public AliPayLedgerItem() {

    }

}
