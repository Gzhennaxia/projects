# 数据库

## 表

### ledger_order 


| Field | Type & Length | Default | Note |
| ----- | ---------- | ---- | ---- |
| id    | int(16) unsigned | Auto Increasment | primary key |
| source_id | int(4) | null | 来源：<br />null：未知<br />1：支付宝<br />2：微信<br />3：淘宝<br />4：美团<br />其余见来源表ledger_source |
| category_id | int(8) | null | 分类<br />null：未知<br />1：<br />其余见分类表ledger_category |
| user_id | int(4) | null |  |




  private Integer id;

    private Integer source;
    
    /**
     * 交易类型
     */
    private Integer type;
    
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