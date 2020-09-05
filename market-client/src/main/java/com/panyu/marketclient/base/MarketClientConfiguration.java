package com.panyu.marketclient.base;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:AccountConfiguration <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:  TODO ADD REASON. <br/>
 * Date:     2018-06-20 16:35 <br/>
 *
 * @author xuwen
 * @see
 * @since JDK 1.8
 */
@Configuration
public class MarketClientConfiguration {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("market","8qGxUaG4RBsiMsiggFblxoq7sYYrKQR8");
    }
}
