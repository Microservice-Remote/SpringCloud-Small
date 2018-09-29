package com.onion.service.user.service;

import com.onion.pojo.HttpWrapper;
import com.onion.pojo.user.Code;

/**
 * Created by Administrator on 2018/2/6 0006.
 */
public interface UserService {

    /**
     * 获取验证码
     * @return
     */
    HttpWrapper<Code> getCode(String phone);
}
