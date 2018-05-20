package com.onion.web;

import com.alibaba.fastjson.JSONObject;
import com.onion.pojo.user.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangqi on 2017/12/1.
 */
public class Bank implements Serializable {

    public static final Map<String,String> mBankMap = new HashMap<>();

    /**
     * 银行的名字
     */
    private String bankName;
    /**
     * 银行的通用code
     */
    private String bankLocalCode;

    /**
     * 第三方编码
     */
    private String bankCode;

    public Bank(String bankCode, String bankLocalCode, String bankName) {
        this.bankName = bankName;
        this.bankLocalCode = bankLocalCode;
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankLocalCode() {
        return bankLocalCode;
    }

    public void setBankLocalCode(String bankLocalCode) {
        this.bankLocalCode = bankLocalCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public static void main(String[] args){
        String http = "http://192.168.1.2:8032/image\\hh\\j.jpg";
        User user = new User();
        user.setPhone(http);
        System.out.println(JSONObject.toJSONString(user));
    }
}
