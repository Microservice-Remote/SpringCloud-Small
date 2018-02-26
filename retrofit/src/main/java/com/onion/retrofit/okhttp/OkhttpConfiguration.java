package com.onion.retrofit.okhttp;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangqi on 2018/2/26.
 */
@Configuration
@EnableConfigurationProperties(OkhttpProperties.class)
public class OkhttpConfiguration {

    private Logger mLogger = LoggerFactory.getLogger(OkhttpConfiguration.class.getName());

    private final OkhttpProperties mOkhttpProperties;

    public OkhttpConfiguration(OkhttpProperties okhttpProperties){
        mOkhttpProperties = okhttpProperties;
    }

    @Bean
    @ConditionalOnMissingBean(OkHttpClient.class)
    public OkHttpClient okhttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

        builder.readTimeout(mOkhttpProperties.getReadTimeOut(), TimeUnit.MILLISECONDS)
                .connectTimeout(mOkhttpProperties.getConnTimeOut(),TimeUnit.MILLISECONDS)
                .writeTimeout(mOkhttpProperties.getWriteTimeOut(),TimeUnit.MILLISECONDS);

        List<String> interceptor = mOkhttpProperties.getInterceptor();
        for (String clazzName : interceptor) {
            builder.addInterceptor(getInterceptor(clazzName));
        }

        List<String> netInterceptor = mOkhttpProperties.getNetInterceptor();
        for (String clazzName : netInterceptor) {
            builder.addNetworkInterceptor(getInterceptor(clazzName));
        }

        return builder.build();
    }

    private Interceptor getInterceptor(String clazzName) {

        try {
            Class<?> aClass = Class.forName(clazzName);
            Object childO = aClass.newInstance();
            if(childO instanceof Interceptor){
                return (Interceptor)childO;
            }else{
                throw new IllegalArgumentException("不是拦截器类型");
            }

        }catch (Exception e){
            mLogger.info("拦截器:"+clazzName);
            throw new IllegalArgumentException("找不到该包");
        }
    }
}
