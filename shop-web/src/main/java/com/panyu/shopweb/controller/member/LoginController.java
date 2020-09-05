package com.panyu.shopweb.controller.member;

import com.panyu.client.base.MemberBaseResponse;
import com.panyu.client.entity.User;
import com.panyu.client.iface.UserClient;
import com.panyu.shopweb.base.WebBaseResponse;
import com.panyu.shopweb.enums.WebResultCodeEnum;
import com.panyu.shopweb.utils.MD5Utils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserClient userClient;


    @RequestMapping("/user")
    @ResponseBody
   public WebBaseResponse<User> login(@RequestBody User user){
        WebBaseResponse<User> webBaseResponse=new WebBaseResponse<>();
//      if(user.getName()==null || user.getPassword()==null){
//
//          webBaseResponse.setCode(WebResultCodeEnum.FAIL.code);
//          webBaseResponse.setMessage("请填完整登录信息");
//          return webBaseResponse;
//      }

//      if(user.getName().trim().length()==0||user.getUserName().trim().length()==0){
////           webBaseResponse.setCode(WebResultCodeEnum.FAIL.code);
//            webBaseResponse.setMessage("信息不能填空");
//            return webBaseResponse;
////        }

        if (StringUtils.isBlank(user.getName())||StringUtils.isBlank(user.getPassword())){
            webBaseResponse.setCode(WebResultCodeEnum.FAIL.code);
            webBaseResponse.setMessage("用户名或密码不能填空");
            return webBaseResponse;
        }


          MemberBaseResponse<User> u = userClient.findByName(user.getName().trim());
          if (u.getData()!=null){
              User userLogin=u.getData();
              String passwordMD5= MD5Utils.toMD5(user.getPassword().trim());
              if(passwordMD5.equals(userLogin.getPassword())){
                  webBaseResponse.setCode(WebResultCodeEnum.SUCCESS.code);
                  webBaseResponse.setMessage(WebResultCodeEnum.SUCCESS.message);
                  webBaseResponse.setData(u.getData());
                  return webBaseResponse;


              }
              webBaseResponse.setCode(WebResultCodeEnum.FAIL.code);
              webBaseResponse.setMessage("用户名或密码错误");
              return webBaseResponse;
          }else{
                  webBaseResponse.setCode(WebResultCodeEnum.FAIL.code);
                  webBaseResponse.setMessage("账号不存在");
                  return webBaseResponse;
              }
          }



   }



