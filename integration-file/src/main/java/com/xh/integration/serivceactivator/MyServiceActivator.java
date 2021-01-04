package com.xh.integration.serivceactivator;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 13:53
 * @description
 */
public class MyServiceActivator implements MessageHandler{


    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        //handled message
    }
}
