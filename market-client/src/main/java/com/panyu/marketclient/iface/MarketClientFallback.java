package com.panyu.marketclient.iface;

import com.panyu.marketclient.base.MarketBaseResponse;
import com.panyu.marketclient.entity.Coupon;
import com.panyu.marketclient.enums.MarketResultCodeEnum;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MarketClientFallback implements FallbackFactory<MarketClient> {


    @Override
    public MarketClient create(Throwable throwable) {
        return new MarketClient() {
            @Override
            public MarketBaseResponse<Coupon> findById(String id) {
                return new MarketBaseResponse<>(MarketResultCodeEnum.SERVER_EXCEPTION);

            }

            @Override
            public MarketBaseResponse<Coupon> addCoupon(Coupon coupon) {
                return new MarketBaseResponse<>(MarketResultCodeEnum.SERVER_EXCEPTION);
            }
        };
    }
}
