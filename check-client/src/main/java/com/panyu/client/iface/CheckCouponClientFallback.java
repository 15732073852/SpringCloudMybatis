package com.panyu.client.iface;

import com.panyu.client.dto.CheckCoupon;
import com.panyu.client.enums.CheckCouponResultCodeEnum;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class CheckCouponClientFallback implements FallbackFactory<CheckCouponClient> {
    @Override
    public CheckCouponClient create(Throwable throwable) {
        return new CheckCouponClient() {
            @Override
            public CheckCoupon findById(String id) {
                return new CheckCoupon();

            }
        };
    }
}
