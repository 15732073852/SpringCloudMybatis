package com.panyu.market.service.impl;

import com.panyu.market.dao.CheckCouponDao;
import com.panyu.market.entity.CheckCoupon;
import com.panyu.market.service.CheckCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckCouponServiceImpl implements CheckCouponService {


    @Autowired
    private CheckCouponDao checkCouponDao;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<CheckCoupon> findAll() {
        return checkCouponDao.findAll();
    }

    /**
     * 查找审核优惠券
     * @param id
     * @return
     */
    @Override
    public CheckCoupon findCheckCouponById(String id) {
        return checkCouponDao.findCheckCouponById(id);
    }

    /**
     * 审核通过优惠券
     * @param id
     * @return
     */
    @Override
    public Integer updateCross(String id) {
        Integer integer = checkCouponDao.updateCross(id);
        return integer;
    }

    /**
     * 拒绝通优惠券审核
     * @param id
     * @return
     */
    @Override
    public Integer refuseCheckCoupon(String id) {
        return checkCouponDao.updateRefuse(id);
    }

    @Override
    public Integer addCheckCoupon(CheckCoupon checkCoupon){

        Integer i= checkCouponDao.addCheckCoupon(checkCoupon);
        return i;
    }


}
