package com.onion.retrofit.api;

import com.onion.retrofit.api.annotation.Api;
import com.onion.retrofit.api.annotation.ApiAnnotation;
import com.onion.retrofit.api.annotation.Parse;
import com.onion.retrofit.api.intercepter.LoggingInterceptor;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangqi on 2017/12/4.
 *
 * 用来注入 Api接口
 */

@Component
public class RetrofitAutowiredProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    @Autowired
    Http mHttp;

    private Logger logger = LoggerFactory.getLogger(RetrofitAutowiredProcessor.class);

    @Override
    public boolean postProcessAfterInstantiation(final Object bean, final String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                Api httpApi = field.getAnnotation(Api.class);
                if (httpApi == null) {
                    return;
                }
                createRetrofitService(bean, field, field.getType());
            }
        });
        return super.postProcessAfterInstantiation(bean, beanName);
    }

    private void createRetrofitService(Object bean, Field field, Class clazz) throws IllegalAccessException {

        ApiAnnotation httpApi = (ApiAnnotation) clazz.getAnnotation(ApiAnnotation.class);

        /**
         * timeout 超时时间配置
         */
        int[] timeout = httpApi.timeOut();
        String baseUrl = httpApi.baseUrl();
        /**
         * 解析baseUrl 默认代付接口
         */
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new LoggingInterceptor());
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(timeout[0],TimeUnit.SECONDS)
                .connectTimeout(timeout[1],TimeUnit.SECONDS)
                .writeTimeout(timeout[2],TimeUnit.SECONDS);
        builder.addInterceptor(loggingInterceptor);

        if (httpApi.interceptor().length > 0) {
            for (Class inter : httpApi.interceptor()) {
                if (Interceptor.class.isAssignableFrom(inter)) {
                    try {
                        builder.addInterceptor((Interceptor) inter.newInstance());
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        OkHttpClient client = builder.build();
        logger.error("构建api对象 拦截器数量:"+client.interceptors().size());
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        
        if(StringUtils.isEmpty(baseUrl)){
            logger.error(httpApi.note()+"baseUrl为空!!!!");
        }

//        String url = PropertiesReaderUtil.read(httpApi.fileName(), httpApi.baseUrl());
        String url = mHttp.getBaseUrl().get(baseUrl);
        logger.info("构建api对象 baseUrl"+url);
        retrofitBuilder.baseUrl(url);
        retrofitBuilder.addConverterFactory(ScalarsConverterFactory.create());
        if(httpApi.parseType() == Parse.XML){
        }else if(httpApi.parseType() == Parse.JSON){
            retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
        }
        retrofitBuilder.client(client);
        Retrofit object = retrofitBuilder.build();
        field.setAccessible(true);
        field.set(bean, object.create(clazz));
        logger.info("构建api对象完成:"+clazz.getName()+"-"+httpApi.note());
    }
}
