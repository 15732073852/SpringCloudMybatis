package com.panyu.shopweb.controller.check;

import com.panyu.client.dto.CheckCoupon;
import com.panyu.client.iface.CheckCouponClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("check")
public class CheckCouponController {

    @Autowired
    private CheckCouponClient checkCouponclient;

    @PostMapping("findById")
    @ResponseBody
    public CheckCoupon findById(@RequestParam(value = "couponId") String couponId) {
        CheckCoupon c=checkCouponclient.findById(couponId);
        return c;
    }
}