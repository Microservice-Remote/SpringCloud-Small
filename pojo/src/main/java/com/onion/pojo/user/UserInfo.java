package com.onion.pojo.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by zhangqi on 2018/9/28.
 */
@Getter
@Setter
public class UserInfo {
    private int id;
    private String userId;
    private Date createDate;
    private Date updateDate;
}
