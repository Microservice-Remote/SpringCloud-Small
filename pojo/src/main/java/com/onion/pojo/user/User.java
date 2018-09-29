package com.onion.pojo.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by OnionMac on 2018/2/6.
 */
@Setter
@Getter
public class User {
    private int id;
    private String userId;
    private String phone;
    private String password;
    private String token;
    private int enable;
    private String email;
    private Date createDate;
    private Date updateDate;
}
