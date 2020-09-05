package com.panyu.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@ComponentScan(basePackages = {"com.panyu.client"})
public class MemberClientAutoConfiguration {

}
