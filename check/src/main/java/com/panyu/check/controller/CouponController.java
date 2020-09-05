package com.panyu.check.controller;

import com.panyu.check.Service.CheckCouponService;
import com.panyu.check.dao.CheckCouponDao;
import com.panyu.check.entity.CheckCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("check")
public class CouponController {

    @Autowired
    private CheckCouponService checkCouponService;

    @GetMapping("test")
    @ResponseBody
    public String test(){
        return "hello";
    }

    @PostMapping("findById")
    @ResponseBody
    public CheckCoupon findById(@RequestParam(value = "couponId") String couponId){
        CheckCoupon checkCoupon =checkCouponService.findById(couponId);
        if(checkCoupon!=null){
            return checkCoupon;
        }
        return null;
    }
    @GetMapping("findAll")
    @ResponseBody
   public List<CheckCoupon> findAll() {
        List<CheckCoupon> list = checkCouponService.findAll();
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }

    @PostMapping("update")
    @ResponseBody
    public CheckCoupon updateCheckCoupon(@RequestBody CheckCoupon checkCoupon){
        Integer integer = checkCouponService.updateCoupon(checkCoupon);
        if(integer>0){
            return checkCouponService.findById(checkCoupon.getId());
        }
        return  null;
    }
}
