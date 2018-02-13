package com.onion.web;

import com.onion.web.hystrix.FriendHystrix;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by OnionMac on 2018/2/13.
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public FriendHystrix fb(){
        return new FriendHystrix();
    }
}
