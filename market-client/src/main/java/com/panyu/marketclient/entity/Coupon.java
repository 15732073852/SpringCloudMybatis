package com.panyu.marketclient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
    /**
     * 优惠券id
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 抵扣金额
     */
    private BigDecimal deductionAmount;

    /**
     * 条件金额
     */
    private BigDecimal conditionalAmount;

    /**
     * 数量
     */
    private int number;

    /**
     * 状态 (有效失效)
     */
    private String status;

    /**
     * 有效天数
     */
    private int effectiveDays;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
