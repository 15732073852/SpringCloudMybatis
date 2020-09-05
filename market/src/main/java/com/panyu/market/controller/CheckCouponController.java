package com.panyu.market.controller;

import com.panyu.market.entity.CheckCoupon;
import com.panyu.market.service.CheckCouponService;
import com.panyu.market.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("check")
public class CheckCouponController {

    @Autowired
    private CheckCouponService checkCouponService;

    @Autowired
    private CouponService couponService;

    @PostMapping("listCoupon")
    @ResponseBody
    public List<CheckCoupon> findAll(){
        List<CheckCoupon> list = checkCouponService.findAll();
        return  list;
    }


    @PostMapping("crossCoupon")
    @ResponseBody
    public  String crossCoupon(@RequestParam(value = "id") String id ){
        Integer res = checkCouponService.updateCross(id);
        if(res>0){
            CheckCoupon checkCoupon=checkCouponService.findCheckCouponById(id);
            if(couponService.updateCross(checkCoupon.getCouponId())>0){
                return  "审核通过";
            }
        }
        return "审核失败";
    }
    @PostMapping("refuseCoupon")
    @ResponseBody
    public  String refuseCoupon(@RequestParam(value = "id") String id ){

        if(checkCouponService.refuseCheckCoupon(id)>0){
            CheckCoupon checkCoupon=checkCouponService.findCheckCouponById(id);
            if(couponService.refuseCoupon(checkCoupon.getCouponId())>0){
                return  "已拒绝";
            }
        }
        return "拒绝失败";
    }
}
