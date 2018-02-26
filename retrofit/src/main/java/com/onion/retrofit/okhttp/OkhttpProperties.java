package com.onion.retrofit.okhttp;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Created by zhangqi on 2018/2/26.
 */
@ConfigurationProperties(prefix = "spring.okhttp")
public class OkhttpProperties {

    private final long DEFAULT_TIMEOUT = 10000;

    private long readTimeOut;
    private long connTimeOut;
    private long writeTimeOut;

    private List<String> netInterceptor;
    private List<String> interceptor;

    public OkhttpProperties(){
        readTimeOut = DEFAULT_TIMEOUT;
        connTimeOut = DEFAULT_TIMEOUT;
        writeTimeOut = DEFAULT_TIMEOUT;
    }

    public List<String> getNetInterceptor() {
        return netInterceptor;
    }

    public void setNetInterceptor(List<String> netInterceptor) {
        this.netInterceptor = netInterceptor;
    }

    public List<String> getInterceptor() {
        return interceptor;
    }

    public void setInterceptor(List<String> interceptor) {
        this.interceptor = interceptor;
    }

    public long getWriteTimeOut() {
        return writeTimeOut;
    }

    public void setWriteTimeOut(long writeTimeOut) {
        this.writeTimeOut = writeTimeOut;
    }

    public long getReadTimeOut() {
        return readTimeOut;
    }

    public void setReadTimeOut(long readTimeOut) {
        this.readTimeOut = readTimeOut;
    }

    public long getConnTimeOut() {
        return connTimeOut;
    }

    public void setConnTimeOut(long connTimeOut) {
        this.connTimeOut = connTimeOut;
    }


}
