package com.onion.service.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.onion.pojo.HttpWrapper;
import com.onion.pojo.ReturnCode;
import com.onion.pojo.user.PhoneAuthCode;
import com.onion.pojo.user.User;
import com.onion.service.user.api.FriendApi;
import com.onion.service.user.service.MailService;
import com.onion.service.user.service.UserService;
import com.onion.util.AuthUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by OnionMac on 2018/2/6.
 */
@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    UserService userService;

    @Autowired
    FriendApi friendApi;

    @Autowired
    MailService mailService;

    @Autowired
    private StringRedisTemplate redisTemplate;
    @GetMapping("user/getName")
    public String getName(){
        return userService.getName();
    }

    @RequestMapping(value = "user/register",method = RequestMethod.POST)
    public HttpWrapper<User> register(@RequestBody User user,String code,String token) {
        return userService.register(user,code,token);
    }

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @RequestMapping(value = "user/sendAuthCode",method = RequestMethod.POST)
    public HttpWrapper<PhoneAuthCode> sendAuthCode(@RequestParam String phone) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("发送验证码的手机号:"+phone);

        HttpWrapper<PhoneAuthCode> wrapper = new HttpWrapper<>();
        PhoneAuthCode phoneAuthCode = new PhoneAuthCode();
        phoneAuthCode.setAuthCode(AuthUtil.createCode(6));
        phoneAuthCode.setPhone(phone);
        phoneAuthCode.setToken(UUID.randomUUID().toString());
        String key = phone;
        logger.info("发送验证码Redis的key:"+key);
        redisTemplate.opsForValue().set(key, JSONObject.toJSONString(phoneAuthCode));
        redisTemplate.expire(key,60, TimeUnit.SECONDS);
        wrapper.setData(phoneAuthCode);
        wrapper.setCode(ReturnCode.SUCCESS);
        wrapper.setInfo("发送验证码成功!");
        return wrapper;
    }

    @RequestMapping(value = "user/getUser/{id}",method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") int id) {
        User userById = userService.findUserById(id);
        return userById;
    }

    @GetMapping("/user/send")
    public String send(String title,String content,String email){
        mailService.sendMail(title,content,email);
        return "同步发送成功";
    }



}
