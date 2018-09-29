package com.onion.web.api;

import com.onion.pojo.HttpWrapper;
import com.onion.pojo.user.PhoneAuthCode;
import com.onion.pojo.user.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by OnionMac on 2018/2/8.
 */
@FeignClient(value = "user-service")
public interface WebUserApi {

    @GetMapping("user/getName")
    String getName();

    @RequestMapping(value = "user/getUser/{id}",method = RequestMethod.GET)
    User findUserById(@PathVariable("id") int id);

    @RequestMapping(value = "user/register",method = RequestMethod.POST)
    HttpWrapper<User> register(User user);

    @RequestMapping(value = "user/sendAuthCode",method = RequestMethod.POST)
    HttpWrapper<PhoneAuthCode> sendAuthCode(@RequestParam("phone") String phone);

    @RequestMapping(value = "user/login",method = RequestMethod.POST)
    HttpWrapper<User> login(User user);
}
