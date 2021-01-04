package com.xh.integration.serivceactivator;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 14:03
 * @description
 */
public class ServiceActivatorConfig {

    @Bean
    @ServiceActivator(inputChannel = "inputChannel")
    public MessageHandler messageHandler() {
        return new MyServiceActivator();
    }
}
