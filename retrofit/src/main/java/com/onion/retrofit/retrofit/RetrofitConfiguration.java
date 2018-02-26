package com.onion.retrofit.retrofit;

import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangqi on 2018/2/26.
 */
@Configuration
@ConditionalOnClass({Retrofit.class, OkHttpClient.class})
@EnableConfigurationProperties(RetrofitProperties.class)
public class RetrofitConfiguration {

    private Logger mLogger = LoggerFactory.getLogger(RetrofitConfiguration.class.getName());

    @Autowired
    OkHttpClient mOkHttpClient;

    private final RetrofitProperties mRetrofitProperties;

    public RetrofitConfiguration(RetrofitProperties retrofitProperties){
        mRetrofitProperties = retrofitProperties;
    }

    @Bean
    @ConditionalOnMissingBean(Retrofit.class)
    public Retrofit retrofit(){
        Retrofit.Builder builder = new Retrofit.Builder();

        builder.baseUrl(mRetrofitProperties.getBaseUrl());

        /**
         * 检测有没有自定义converterFactory
         */
        String converterFactory = mRetrofitProperties.getConverterFactory();
        Converter.Factory factory = getConverterFactory(converterFactory);

        builder.addConverterFactory(factory);
        builder.client(mOkHttpClient);
        return builder.build();
    }

    private Converter.Factory getConverterFactory(String converterFactory) {

        Converter.Factory factory = null;

        if(converterFactory == null && converterFactory.trim().equals("")){
            factory = GsonConverterFactory.create();
            return factory;
        }

        try {
            Class<?> aClass = Class.forName(converterFactory);
            Object childFactory = aClass.newInstance();
            if(childFactory instanceof Converter.Factory){
                factory = (Converter.Factory)childFactory;
            }else{
                throw new IllegalArgumentException("并不是Converter.Factory的子类");
            }
        } catch (Exception e){
            throw new IllegalArgumentException("类路径不存在");
        }


        return factory;
    }

}
