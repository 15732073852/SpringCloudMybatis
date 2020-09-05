package com.panyu.client.iface;

import com.panyu.client.dto.CheckCoupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "check" ,fallbackFactory = CheckCouponClientFallback.class)
public interface CheckCouponClient {

    @RequestMapping("{check/findById}")
    @ResponseBody
    public CheckCoupon findById(@RequestParam String couponId);


}
