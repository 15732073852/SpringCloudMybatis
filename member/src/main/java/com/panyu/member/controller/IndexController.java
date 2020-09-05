package com.panyu.member.controller;


import com.panyu.client.base.MemberBaseResponse;
import com.panyu.client.enums.MemberResultCodeEnum;
import com.panyu.marketclient.base.MarketBaseResponse;
import com.panyu.marketclient.entity.Coupon;
import com.panyu.marketclient.iface.MarketClient;
import com.panyu.member.entity.User;
import com.panyu.member.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("member")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private MarketClient marketClient;

    @PostMapping("/byId")
    @ResponseBody
    public MarketBaseResponse test(@RequestParam String id){
        MarketBaseResponse<Coupon> byId = marketClient.findById(id);
        return  byId;

    }

    @PostMapping("/findById")
    @ResponseBody
    public  MemberBaseResponse<User> findById(@RequestParam String id) {
        MemberBaseResponse  memberBaseResponse=new MemberBaseResponse();
         User user= userService.findById(id);
         memberBaseResponse.setData(user);
         memberBaseResponse.set(MemberResultCodeEnum.SUCCESS);
         return  memberBaseResponse;
    }

    @PostMapping("/add")
    @ResponseBody
    public MemberBaseResponse<User>  addUser(@RequestBody User user) {
        MemberBaseResponse<User>  memberBaseResponse=new MemberBaseResponse<User>();

        user.setId(UUID.randomUUID().toString().replaceAll("-", ""));

        if (userService.addUser(user) > 0) {

            memberBaseResponse.setData( userService.findById(user.getId()));
            memberBaseResponse.set(MemberResultCodeEnum.SUCCESS);
            return  memberBaseResponse;
        }

        return  null;

    }

    @PostMapping("/findByName")
    @ResponseBody
    public  MemberBaseResponse<User> findByName(@RequestParam String name){
        MemberBaseResponse<User> memberBaseResponse = new MemberBaseResponse<>();
        User user = userService.findByName(name);
        if(user != null){
            memberBaseResponse.setCode(MemberResultCodeEnum.SUCCESS.code);
            memberBaseResponse.setMessage(MemberResultCodeEnum.SUCCESS.message);
            memberBaseResponse.setData(user);
            return memberBaseResponse;
        }

        memberBaseResponse.setCode(MemberResultCodeEnum.FAIL.code);
        memberBaseResponse.setMessage(MemberResultCodeEnum.FAIL.message);
        return  memberBaseResponse;
    }
}
