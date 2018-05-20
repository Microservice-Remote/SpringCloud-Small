package com.onion.message;


import io.netty.channel.Channel;
import net.openmob.mobileimsdk.server.event.ServerEventListener;

/**
 * Created by Administrator on 2018/4/4 0004.
 */
public class ServerEventListenerImpl implements ServerEventListener {
    @Override
    public int onVerifyUserCallBack(String s, String s1, String s2, Channel channel) {
        return 0;
    }

    @Override
    public void onUserLoginAction_CallBack(String s, String s1, Channel channel) {

    }

    @Override
    public void onUserLogoutAction_CallBack(String s, Object o, Channel channel) {

    }

    @Override
    public boolean onTransBuffer_CallBack(String s, String s1, String s2, String s3, int i, Channel channel) {
        return false;
    }

    @Override
    public void onTransBuffer_C2C_CallBack(String s, String s1, String s2, String s3, int i) {

    }

    @Override
    public boolean onTransBuffer_C2C_RealTimeSendFaild_CallBack(String s, String s1, String s2, String s3, int i) {
        return false;
    }
}
