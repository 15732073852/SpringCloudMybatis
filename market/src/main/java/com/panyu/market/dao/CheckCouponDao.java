package com.panyu.market.dao;

import com.panyu.market.entity.CheckCoupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CheckCouponDao {
    public CheckCoupon findCheckCouponById(String id);

    public  Integer updateCross(String id);

    public  Integer updateRefuse(String id);
    
    public List<CheckCoupon> findAll();

    /**
     * 插入到check_coupon表
     */
    public Integer addCheckCoupon(CheckCoupon checkCoupon);

}
