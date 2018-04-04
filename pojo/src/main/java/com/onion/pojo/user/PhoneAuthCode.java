package com.onion.pojo.user;

/**
 * Created by OnionMac on 2018/3/12.
 */
public class PhoneAuthCode {

    private String authCode;

    private String token;

    private String phone;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
