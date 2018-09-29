package com.onion.service.user;

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
    }
}
