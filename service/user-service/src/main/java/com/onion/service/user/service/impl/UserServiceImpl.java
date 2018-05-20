package com.onion.service.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.onion.pojo.HttpWrapper;
import com.onion.pojo.ReturnCode;
import com.onion.pojo.user.PhoneAuthCode;
import com.onion.pojo.user.User;
import com.onion.service.user.mapper.UserMapper;
import com.onion.service.user.service.UserService;
import com.onion.util.AuthUtil;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by OnionMac on 2018/2/6.
 */
@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class.getName());

    @Autowired
    UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public String getName() {
        return "user-service";
    }

    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public HttpWrapper<User> register(User user,String code,String token) {
        HttpWrapper<User> wrapper = new HttpWrapper<>();
        if(user == null){
            wrapper.setCode(ReturnCode.PARAMS_ERROR);
            return wrapper;
        }

        String phone = user.getPhone();
        String redis = redisTemplate.opsForValue().get(phone);
        logger.info("redis里的缓存验证码信息:"+redis);
        PhoneAuthCode curr = JSONObject.parseObject(redis,PhoneAuthCode.class);

        /**
         * 没有缓存的情况  可能验证码已经过期了
         */
        if(curr == null){
            wrapper.setCode(ReturnCode.AUTHCODE_EXPIRE);
            wrapper.setInfo("验证码已经失效,请重新发送!");
            return wrapper;
        }

        if (!curr.getAuthCode().equals(code) || !curr.getToken().equals(token)){
            wrapper.setCode(ReturnCode.AUTHCODE_EXPIRE);
            wrapper.setInfo("验证码已经失效,请重新发送!");
            return wrapper;
        }
        /**
         * 查询用户是否被注册过
         */
        User fUser = userMapper.findUserByPhone(user.getPhone());
        if(fUser != null){
            wrapper.setCode(ReturnCode.RE_REGISTER);
            wrapper.setInfo("该手机号已被注册!");
            return wrapper;
        }

        /**
         * 生成userId  注册用户
         */
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        user.setEnable(0);
        user.setPassword(AuthUtil.md5Salt(user.getPassword()));
        /**
         * 插入数据库记录
         */
        int result = userMapper.insertUser(user);
        if(result > 0){
            user.setId(result);
            wrapper.setInfo("注册成功");
            wrapper.setCode(ReturnCode.SUCCESS);
            wrapper.setData(user);
        }

        return wrapper;
    }

    @Override
    public HttpWrapper<User> register(User user) {
        HttpWrapper<User> wrapper = new HttpWrapper<>();
        User fUser = userMapper.findUserByPhone(user.getPhone());
        if(fUser != null){
            wrapper.setCode(ReturnCode.RE_REGISTER);
            wrapper.setInfo("该手机号已被注册!");
            return wrapper;
        }

        /**
         * 生成userId  注册用户
         */
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        user.setEnable(0);
        user.setPassword(AuthUtil.md5Salt(user.getPassword()));
        /**
         * 插入数据库记录
         */
        int result = userMapper.insertUser(user);
        if(result > 0){
            user.setId(result);
            wrapper.setInfo("注册成功");
            wrapper.setCode(ReturnCode.SUCCESS);
            wrapper.setData(user);
        }

        return wrapper;
    }

    @Override
    public HttpWrapper<User> login(@NotNull User user) {
        HttpWrapper<User> wrapper = new HttpWrapper<>();

        User u = userMapper.findUserByPhone(user.getPhone());

        if(u.getPassword().equals(AuthUtil.md5Salt(user.getPassword()))){
            wrapper.setInfo("登录成功");
            wrapper.setData(u);
            wrapper.setCode(ReturnCode.SUCCESS);
        }else{
            wrapper.setInfo("密码错误");
            wrapper.setCode(ReturnCode.PASSWORD_ERROR);
        }

        return wrapper;
    }
}
