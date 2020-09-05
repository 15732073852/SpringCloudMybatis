package com.panyu.shopweb.controller.market;

import com.panyu.marketclient.base.MarketBaseResponse;
import com.panyu.marketclient.entity.Coupon;
import com.panyu.marketclient.enums.MarketResultCodeEnum;
import com.panyu.marketclient.iface.MarketClient;
import com.panyu.shopweb.base.WebBaseResponse;
import com.panyu.shopweb.enums.WebResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("market")
public class CouponController {

    @Autowired
    private MarketClient marketClient;

    /**
     * 查找优惠券
     * @param id
     * @return
     */
    @PostMapping("findById")
    @ResponseBody
    public WebBaseResponse<Coupon> findById(@RequestParam(value = "id") String id){
        MarketBaseResponse marketBaseResponse=marketClient.findById(id);
        WebBaseResponse webBaseResponse=new WebBaseResponse();
        if (marketBaseResponse.getData()==null){
            webBaseResponse.setCode(MarketResultCodeEnum.FAIL.code);
            webBaseResponse.setMessage(MarketResultCodeEnum.FAIL.message);
            return webBaseResponse;
        }
        webBaseResponse.setData(marketBaseResponse.getData());
        webBaseResponse.setMessage(WebResultCodeEnum.SUCCESS.message);
        webBaseResponse.setCode(WebResultCodeEnum.SUCCESS.code);
        return webBaseResponse;
    }

    /**
     * 添加优惠券
     * @param coupon
     * @return
     */
    @PostMapping("addCoupon")
    @ResponseBody
    public  WebBaseResponse<Coupon> addCoupon(@RequestBody Coupon coupon){
        WebBaseResponse webBaseResponse=new WebBaseResponse();
        MarketBaseResponse marketBaseResponse=marketClient.addCoupon(coupon);
        if (marketBaseResponse.getData()==null){
            webBaseResponse.setCode(MarketResultCodeEnum.FAIL.code);
            webBaseResponse.setMessage(MarketResultCodeEnum.FAIL.message);
            return webBaseResponse;
        }
        webBaseResponse.setData(marketBaseResponse.getData());
        webBaseResponse.setCode(WebResultCodeEnum.SUCCESS.code);
        return webBaseResponse;
    }

}
