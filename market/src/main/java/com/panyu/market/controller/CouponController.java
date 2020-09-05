package com.panyu.market.controller;

import com.panyu.client.base.MemberBaseResponse;
import com.panyu.client.entity.User;
import com.panyu.client.enums.MemberResultCodeEnum;
import com.panyu.client.iface.UserClient;
import com.panyu.market.entity.CheckCoupon;
import com.panyu.market.entity.Coupon;
import com.panyu.market.service.CheckCouponService;
import com.panyu.market.service.CouponService;
import com.panyu.marketclient.base.MarketBaseResponse;
import com.panyu.marketclient.enums.MarketResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("coupon")
public class CouponController {

    @Autowired
    private UserClient userClient;

    @ResponseBody
    @PostMapping("test")
    public  String test(){

        User user=new User();
        user.setAge(2);
        user.setName("1");
        user.setBalance("2");
        user.setUserName("2");

        MemberBaseResponse<User> byId = userClient.addUser(user);

         user = byId.getData();
        return  user.getName();

    }

    @Autowired
    private CouponService couponService;

    @Autowired
    private CheckCouponService checkCouponService;

    @PostMapping("findById")
    @ResponseBody
    public MarketBaseResponse findById(@RequestParam String id){
        MarketBaseResponse marketBaseResponse=new MarketBaseResponse();
        if(couponService.findById(id)!=null){
            Coupon coupon =couponService.findById(id);
            marketBaseResponse.setData(coupon);
            marketBaseResponse.set(MarketResultCodeEnum.SUCCESS);
            return  marketBaseResponse;
        };
        return null;
    }

//    @PostMapping("findByUserId")
//    @ResponseBody
//    public MemberBaseResponse<User> findByUserId(@RequestParam(value="id") String userId){
//        MemberBaseResponse<User> byId = userClient.findById(userId);
//        if(byId!=null)
//        {
//          // return  couponService.findByUserId(userId);
//            return byId;
//        }
//        return  null;
//    }
   @PostMapping("addCoupon")
   @ResponseBody
    public MemberBaseResponse<Coupon> addCoupon(@RequestBody Coupon coupon){
       MemberBaseResponse<Coupon> addCoupon=new MemberBaseResponse<Coupon>();
        if(couponService.addCoupon(coupon)>0){

            //保存到经理表
            CheckCoupon checkCoupon = new CheckCoupon();
            checkCoupon.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            checkCoupon.setCouponId(coupon.getId());//优惠券ID
            checkCoupon.setCouponName(coupon.getName());//名称
            checkCoupon.setCouponType(coupon.getType());//类型
            checkCoupon.setCouponNumber(coupon.getNumber());//数量
            checkCoupon.setCouponDeductionAmount(coupon.getDeductionAmount());//抵扣金额
            checkCoupon.setCouponConditionalAmount(coupon.getConditionalAmount());//条件金额
            checkCoupon.setCouponEffectiveDays(coupon.getEffectiveDays());//有效期
            //状态，创建时间，更新时间在xml里写

            Integer i=checkCouponService.addCheckCoupon(checkCoupon);
            if(i>0){
                addCoupon.setData(couponService.findById(coupon.getId()));
                addCoupon.setMessage(MemberResultCodeEnum.SUCCESS.toString());
                return addCoupon;
            }
        }
        return null;
   }
}
