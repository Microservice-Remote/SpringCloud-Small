package com.onion.web.config;

import com.onion.web.api.TestApi;
import okhttp3.OkHttpClient;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

/**
 * Created by zhangqi on 2018/2/26.
 */
@Configuration
@ConditionalOnClass({OkHttpClient.class, Retrofit.class})
public class ApiConfiguration {

    @Autowired
    Retrofit mRetrofit;

    @Bean
    @ConditionalOnMissingBean(TestApi.class)
    public TestApi testapi(){
        return mRetrofit.create(TestApi.class);
    }
}
