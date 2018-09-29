package com.onion.service.user.controller;

import com.onion.pojo.HttpWrapper;
import com.onion.pojo.user.Code;
import com.onion.service.user.api.FriendApi;
import com.onion.service.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by OnionMac on 2018/2/6.
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    UserService userService;

    @Autowired
    FriendApi friendApi;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/getCode")
    public HttpWrapper<Code> getCOde(String phone){

        return userService.getCode(phone);
    }
}
