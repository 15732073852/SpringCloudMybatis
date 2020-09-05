package com.panyu.marketclient.iface;

import com.panyu.marketclient.base.MarketBaseResponse;
import com.panyu.marketclient.base.MarketClientConfiguration;
import com.panyu.marketclient.entity.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(
        value = "market",
        configuration = MarketClientConfiguration.class,
        fallbackFactory = MarketClientFallback.class
)
public interface MarketClient {

    @PostMapping({"coupon/findById"})
    @ResponseBody
    public MarketBaseResponse<Coupon> findById(@RequestParam String id);

    @PostMapping("coupon/addCoupon")
    @ResponseBody
    public MarketBaseResponse<Coupon> addCoupon(@RequestBody Coupon coupon);


}
