package com.onion.web.Interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by zhangqi on 2017/12/22.
 * e-mail : ${email}
 * desc :
 *
 * header参数的封装
 */

public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("123", "123")
                .addHeader("1234", "123")
                .build();
        return chain.proceed(request);
    }
}
