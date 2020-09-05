package com.panyu.check.dao;

import com.panyu.check.entity.CheckCoupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CheckCouponDao {

    public CheckCoupon findById(String couponId);

    public List<CheckCoupon> findAll();

    public Integer updateCoupon(CheckCoupon checkCoupon);
}
