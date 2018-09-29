package com.onion.retrofit.api.intercepter;

import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangqi on 2017/12/4.
 */
public class LoggingInterceptor implements HttpLoggingInterceptor.Logger {

    private static Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public void log(String s) {
        logger.info(s);
    }
}