package com.panyu.check.Service;

import com.panyu.check.dao.CheckCouponDao;
import com.panyu.check.entity.CheckCoupon;

import java.util.List;

public interface CheckCouponService {


    public CheckCoupon findById(String couponId);

    public List<CheckCoupon> findAll();

    public Integer updateCoupon(CheckCoupon checkCoupon);

}
