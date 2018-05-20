package com.onion.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.onion.pojo.City;
import com.onion.pojo.HttpWrapper;
import com.onion.pojo.user.Friend;
import com.onion.pojo.user.PhoneAuthCode;
import com.onion.pojo.user.User;
import com.onion.web.Bank;
import com.onion.web.api.FriendApi;
import com.onion.web.api.TestApi;
import com.onion.web.api.WebUserApi;
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

    @Autowired
    TestApi mTestApi;

    @GetMapping("/getName")
    public String getName(){
        return Bank.mBankMap.get("03080000");
    }

    @PostMapping("/register")
    public HttpWrapper<User> register(User user,String code,String token) {
        return userApi.register(user,code,token);
    }

    @PostMapping("/getCode")
    public HttpWrapper<PhoneAuthCode> getCode(String phone) {
        return userApi.sendAuthCode(phone);
    }

    @GetMapping("/get")
    public String get() throws IOException {
        Response<City> execute = mTestApi.getCity().execute();
        return JSONObject.toJSONString(execute.body());
    }

    @HystrixCommand(fallbackMethod = "hiError") //hystrix
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") int id){
        return userApi.findUserById(id);
    }

    @GetMapping("/getFriend/{id}")
    public Friend getFriend(@PathVariable("id") int id){
        return friendApi.findFriendById(id);
    }

    public User hiError(int id) {
        User user = new User();
        user.setId(id+11111);
        return user;
    }


}
