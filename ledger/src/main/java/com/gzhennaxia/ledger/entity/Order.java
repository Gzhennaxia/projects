package com.gzhennaxia.ledger.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author bo li
 * @date 2020-07-22 12:07
 */
@Data
public class Order {

    private Integer id;

    private Integer sourceId;

    private Integer categoryId;

    private Integer userId;

    private Integer merchantId;

    /**
     * 正数：收入
     * 负数：支出
     *
     * @author bli@skystartrade.com
     * @date 2020-07-23 16:45
     */
    private BigDecimal amount;

    private Date createTime;

    /**
     * 支付方式
     */
    private Integer payType;

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
}
