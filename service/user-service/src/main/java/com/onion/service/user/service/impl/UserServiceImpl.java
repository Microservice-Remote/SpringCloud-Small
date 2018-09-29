package com.onion.service.user.service.impl;

import com.onion.pojo.HttpWrapper;
import com.onion.pojo.user.Code;
import com.onion.service.user.mapper.UserMapper;
import com.onion.service.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by OnionMac on 2018/2/6.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public HttpWrapper<Code> getCode(String phone) {
        HttpWrapper<Code> wrapper = new HttpWrapper<>();

        int code = new Random().nextInt(10000);
        ValueOperations<String,String> re = redisTemplate.opsForValue();
        String redisCode = re.get(phone);
        if(!StringUtils.isEmpty(redisCode)){
            wrapper.setCode(201);
            wrapper.setInfo("验证码已经发送,请稍后再试!");
            return wrapper;
        }
        re.set(phone,String.valueOf(code),1, TimeUnit.MINUTES);
        Code codes = new Code();
        codes.setCode(String.valueOf(code));
        wrapper.setCode(200);
        wrapper.setInfo("发送验证码成功!");
        wrapper.setData(codes);
        return wrapper;
    }
}
