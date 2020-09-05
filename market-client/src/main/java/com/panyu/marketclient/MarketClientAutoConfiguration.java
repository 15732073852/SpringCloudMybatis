package com.panyu.marketclient;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@ComponentScan(basePackages = {"com.panyu.marketclient"})
public class MarketClientAutoConfiguration {


}
