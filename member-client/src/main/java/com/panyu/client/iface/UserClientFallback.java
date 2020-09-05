package com.panyu.client.iface;

import com.panyu.client.base.MemberBaseResponse;
import com.panyu.client.entity.User;
import com.panyu.client.enums.MemberResultCodeEnum;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public MemberBaseResponse<User> findById(String id) {
                return new MemberBaseResponse<>(MemberResultCodeEnum.SERVER_EXCEPTION);

            }

            @Override
            public MemberBaseResponse<User> addUser(User user) {
                return new MemberBaseResponse<>(MemberResultCodeEnum.SERVER_EXCEPTION);
            }
            @Override
            public MemberBaseResponse<User> findByName(String id) {
                return new MemberBaseResponse<>(MemberResultCodeEnum.SERVER_EXCEPTION);

            }
        };
    }
}
