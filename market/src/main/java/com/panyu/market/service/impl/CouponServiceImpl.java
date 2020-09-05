package com.panyu.market.service.impl;

import com.panyu.market.dao.CouponDao;
import com.panyu.market.entity.CheckCoupon;
import com.panyu.market.entity.Coupon;
import com.panyu.market.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponDao couponDao;

    @Override
    public Coupon findById(String id) {
          if(couponDao.findById(id)!=null){
              return couponDao.findById(id);
          }
        return null;
    }

    @Override
    public Integer addCoupon(Coupon coupon) {
        coupon.setId(UUID.randomUUID().toString().replaceAll("-",""));

        Integer in = couponDao.addCoupon(coupon);
        if(in>0){
           return in;
        }
        return null;
    }

    @Override
    public Integer updateCross(String id) {
        return couponDao.updateCoupon(id);
    }
    @Override
    public Integer refuseCoupon(String id) {
        return couponDao.updateRefuse(id);
    }


}
