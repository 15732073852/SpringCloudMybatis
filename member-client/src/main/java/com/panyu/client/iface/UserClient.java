package com.panyu.client.iface;

import com.panyu.client.base.MemberBaseResponse;
import com.panyu.client.base.MemberClientConfiguration;
import com.panyu.client.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(
        value = "member",
        configuration = MemberClientConfiguration.class,
        fallbackFactory = UserClientFallback.class
)
public interface UserClient {

    @PostMapping({"member/findById"})
    @ResponseBody
    public MemberBaseResponse<User> findById(@RequestParam String id);

    @PostMapping("member/add")
    @ResponseBody
    public MemberBaseResponse<User> addUser(@RequestBody User user);

    @PostMapping("member/findByName")
    @ResponseBody
    public MemberBaseResponse<User> findByName(@RequestParam String name);

}
