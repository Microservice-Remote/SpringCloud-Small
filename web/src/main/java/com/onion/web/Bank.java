package com.onion.web;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

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


        String json = "{\n" +
                "\t\"bankName\": \"111\"\n" +
                "}";

        Bank bank = JSONObject.parseObject(json, Bank.class);
        Bank bank1 = new Gson().fromJson(json,Bank.class);
        System.out.println(JSONObject.toJSONString(bank));
        System.out.println(JSONObject.toJSONString(bank1));
        System.out.println(bank.getBankLocalCode());
        System.out.println(bank1.getBankLocalCode());

    }
}
