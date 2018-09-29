package com.onion.pojo;

import java.io.Serializable;

/**
 * Created by OnionMac on 2018/3/8.
 */
public class HttpWrapper<T> implements Serializable{


    private int code;
    private T data;
    private String info;

    public HttpWrapper(){
        info = "系统繁忙";
        code = ReturnCode.SYSTEM_ERROR;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        if(code == ReturnCode.PARAMS_ERROR){
            info = "参数错误";
        }
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
