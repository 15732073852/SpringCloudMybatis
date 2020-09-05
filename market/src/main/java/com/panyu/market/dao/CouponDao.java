package com.panyu.market.dao;

import com.panyu.market.entity.CheckCoupon;
import com.panyu.market.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponDao {

    public Coupon findById(String id);

    /**
     * 插入到Coupon表
     *
     * @param coupon
     * @return
     */
    public Integer addCoupon(Coupon coupon);

    /**
     * 更新coupon状态为通过
     *
     * @param id
     * @return
     */
    public Integer updateCoupon(String id);

    /**
     * 更新状态为未通过
     * @param id
     * @return
     */
    public Integer updateRefuse(String id );
}

