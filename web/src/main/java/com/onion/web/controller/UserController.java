package com.onion.web.controller;

import com.onion.pojo.HttpWrapper;
import com.onion.pojo.user.User;
import com.onion.retrofit.api.annotation.Api;
import com.onion.web.api.FriendApi;
import com.onion.web.api.WebUserApi;
import com.onion.web.api.YouTuApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by OnionMac on 2018/2/6.
 */
@RestController
@RequestMapping("web")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    WebUserApi userApi;

    @Autowired
    FriendApi friendApi;


    @Api
    YouTuApi mYouTuApi;

    @GetMapping("/test")
    public String test(){

        try {
            Response<String> execute = mYouTuApi.getCity().execute();
            System.out.println(execute.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @GetMapping("/getName")
    public String getName(){
        return userApi.getName();
    }


    @PostMapping("/register")
    public HttpWrapper<User> register(@RequestBody User user){
        return userApi.register(user);
    }

    @PostMapping("/login")
    public HttpWrapper<User> login(@RequestBody User user){
        return userApi.login(user);
    }

}
