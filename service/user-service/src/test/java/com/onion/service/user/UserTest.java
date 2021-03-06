package com.onion.service.user;

import com.alibaba.fastjson.JSONObject;
import com.onion.pojo.HttpWrapper;
import com.onion.pojo.user.PhoneAuthCode;
import com.onion.pojo.user.User;
import com.onion.service.user.controller.UserController;
import com.onion.service.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by OnionMac on 2018/3/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    Logger logger = LoggerFactory.getLogger(UserTest.class.getName());

    @Autowired
    UserService userService;

    @Autowired
    UserController userController;

    @Test
    public void register(){
        System.out.println(userController.toString());
        String phone = "13270665702";
        HttpWrapper<PhoneAuthCode> result = userController.sendAuthCode(phone);
        logger.debug(JSONObject.toJSONString(result));

        User user = new User();
        user.setPassword("123");
        user.setPhone(phone);
        HttpWrapper<User> user1 = userController.register(user, result.getData().getAuthCode(), result.getData().getToken());
        System.out.println(JSONObject.toJSONString(user1));
    }
}
