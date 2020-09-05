package com.panyu.market.service;

import com.panyu.market.entity.CheckCoupon;

import java.util.List;

public interface CheckCouponService {

    public CheckCoupon findCheckCouponById(String id);

    public Integer updateCross(String id);

    public Integer refuseCheckCoupon(String id);

    public List<CheckCoupon> findAll();

    public Integer addCheckCoupon(CheckCoupon checkCoupon);
}
