package com.panyu.shopweb.controller.member;

import com.panyu.client.base.MemberBaseResponse;
import com.panyu.client.entity.User;
import com.panyu.client.enums.MemberResultCodeEnum;
import com.panyu.client.iface.UserClient;
import com.panyu.shopweb.base.WebBaseResponse;
import com.panyu.shopweb.enums.WebResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("shopWeb")
public class MemberController {

    @Autowired
    private UserClient userClient;

    @PostMapping("/hello")
    @ResponseBody
    public  String index(){
        return "hello";
    }

    @PostMapping("findById")
    @ResponseBody
    public WebBaseResponse<User> findById(@RequestParam(value = "id") String id){
        MemberBaseResponse<User> memberBaseResponse = userClient.findById(id);
        WebBaseResponse webBaseResponse=new WebBaseResponse();
        if ( memberBaseResponse.getData() == null){
            webBaseResponse.setCode(MemberResultCodeEnum.FAIL.code);
            webBaseResponse.setMessage(MemberResultCodeEnum.FAIL.message);
            webBaseResponse.setErrorCode("数据库没有对应的对象");

            return webBaseResponse;
        }
        webBaseResponse.setCode(WebResultCodeEnum.SUCCESS.code);
        webBaseResponse.setData(memberBaseResponse.getData());
        webBaseResponse.setMessage(MemberResultCodeEnum.SUCCESS.message);
        return webBaseResponse;
    }


}
