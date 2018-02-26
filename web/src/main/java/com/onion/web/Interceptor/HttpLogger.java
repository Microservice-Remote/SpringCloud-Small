package com.onion.web.Interceptor;

import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by OnionMac on 17/9/22.
 */

public class HttpLogger implements HttpLoggingInterceptor.Logger {

    private Logger mLogger = LoggerFactory.getLogger(HttpLogger.class.getName());

    @Override
    public void log(String message) {
        mLogger.info(message);
    }
}