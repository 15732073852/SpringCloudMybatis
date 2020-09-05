package com.panyu.check.Service.Impl;

import com.panyu.check.Service.CheckCouponService;
import com.panyu.check.dao.CheckCouponDao;
import com.panyu.check.entity.CheckCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CheckCouponServiceImpl implements CheckCouponService {

    @Autowired
    private CheckCouponDao checkCouponDao;
    @Override
    public CheckCoupon findById(String couponId) {
        return checkCouponDao.findById(couponId);
    }

    @Override
    public List<CheckCoupon> findAll() {

        return checkCouponDao.findAll();
    }

    @Override
    public Integer updateCoupon(CheckCoupon checkCoupon) {

        return checkCouponDao.updateCoupon(checkCoupon);
    }
}
