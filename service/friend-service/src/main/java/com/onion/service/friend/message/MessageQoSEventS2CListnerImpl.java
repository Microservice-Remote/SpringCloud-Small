package com.onion.service.friend.message;

import net.openmob.mobileimsdk.server.event.MessageQoSEventListenerS2C;
import net.openmob.mobileimsdk.server.protocal.Protocal;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/4 0004.
 */
public class MessageQoSEventS2CListnerImpl implements MessageQoSEventListenerS2C{

    @Override
    public void messagesLost(ArrayList<Protocal> arrayList) {

    }

    @Override
    public void messagesBeReceived(String s) {

    }
}