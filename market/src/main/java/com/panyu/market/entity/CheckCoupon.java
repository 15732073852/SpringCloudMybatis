package com.panyu.market.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckCoupon {

	private String id;
	private String checkerId;//审核人id
	private String checkerName;//审核人名字
	private String adminUserId;//申请人
	private String adminUserLoginName;//申请人名字
	private String couponId;//优惠券id
	private String couponType;//类型
	private String couponName;//名称
	private BigDecimal couponDeductionAmount;//抵扣金额
	private BigDecimal couponConditionalAmount;//条件金额
	private int couponNumber;//数量
	private int couponEffectiveDays;//有效期
	private String couponStatus;//状态
	private Date couponCreateTime;//创建时间
	private Date couponUpdateTime;//更新时间


	
}
