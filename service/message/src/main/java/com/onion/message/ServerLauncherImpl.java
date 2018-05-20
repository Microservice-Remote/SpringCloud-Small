package com.onion.message;

import net.nettime.mobileimsdk.server.netty.MBObserver;
import net.openmob.mobileimsdk.server.ServerLauncher;
import net.openmob.mobileimsdk.server.utils.LocalSendHelper;

import java.io.IOException;

/**
 * Created by Administrator on 2018/4/4 0004.
 */
public class ServerLauncherImpl extends ServerLauncher {

    private static ServerLauncherImpl instance = null;

    public ServerLauncherImpl() throws IOException {
        super();
    }

    @Override
    protected void initListeners() {
        // ** 设置回调
        this.setServerEventListener(new ServerEventListenerImpl());
        this.setServerMessageQoSEventListener(new MessageQoSEventS2CListnerImpl());
    }

    public static ServerLauncherImpl getInstance() throws IOException
    {
        if(instance == null)
        {
            // 设置AppKey
            ServerLauncher.appKey = "zhangqi";
            ServerLauncherImpl.PORT = 7901;
//          ServerLauncherImpl.setSenseMode(SenseMode.MODE_10S);
            instance = new ServerLauncherImpl();
        }
        return instance;
    }

    public static void main(String[] args) throws Exception
    {


    }
}
