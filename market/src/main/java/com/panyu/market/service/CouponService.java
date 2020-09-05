package com.panyu.market.service;

import com.panyu.market.entity.CheckCoupon;
import com.panyu.market.entity.Coupon;

public interface CouponService {


    public Coupon findById(String id);

    public Integer addCoupon(Coupon coupon);


    public  Integer updateCross(String id);

    public  Integer refuseCoupon(String id);
}
