package com.onion.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.onion.pojo.City;
import com.onion.pojo.user.Friend;
import com.onion.pojo.user.User;
import com.onion.web.api.FriendApi;
import com.onion.web.api.TestApi;
import com.onion.web.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by OnionMac on 2018/2/6.
 */
@RestController
@RequestMapping("web-user")
public class UserController {


    @Autowired
    UserApi userService;

    @Autowired
    FriendApi friendApi;

    @Autowired
    TestApi mTestApi;

    @GetMapping("/getName")
    public String getName(){
        return "web";
    }

    @GetMapping("/get")
    public String get() throws IOException {
        Response<City> execute = mTestApi.getCity().execute();

        return JSONObject.toJSONString(execute.body());
    }

    @HystrixCommand(fallbackMethod = "hiError") //hystrix
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.findUserById(id);
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
