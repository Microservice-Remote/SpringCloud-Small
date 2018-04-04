package com.onion.api.userapi;

import com.onion.pojo.HttpWrapper;
import com.onion.pojo.user.PhoneAuthCode;
import com.onion.pojo.user.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by OnionMac on 2018/2/6.
 */
public interface UserApi {

    @GetMapping("user/getName")
    String getName();

    @RequestMapping(value = "user/getUser/{id}",method = RequestMethod.GET)
    User findUserById(@PathVariable("id") int id);

    @RequestMapping(value = "user/register",method = RequestMethod.POST)
    HttpWrapper<User> register(User user);

    @RequestMapping(value = "user/sendAuthCode",method = RequestMethod.POST)
    HttpWrapper<PhoneAuthCode> sendAuthCode(String phone);
}
