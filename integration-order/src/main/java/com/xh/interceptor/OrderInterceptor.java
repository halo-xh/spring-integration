package com.xh.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 15:33
 */
@Slf4j
@Component
public class OrderInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        log.info("{} start send message: {}",channel.getClass().getName(),message.getHeaders());
        return message;
    }

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        log.info("{} send message: {}",channel.getClass().getName(),message.getHeaders());
    }

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        log.info("{} send message complete: {}",channel.getClass().getName(),message.getHeaders());
    }

    // This only applies to PollableChannels.
    @Override
    public boolean preReceive(MessageChannel channel) {
        log.info("begin receive message ");
        return true;
    }

    // This only applies to PollableChannels.
    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        log.info("{} receive message: {}",channel.getClass().getName(),message.getHeaders());
        return message;
    }

    // This only applies to PollableChannels.
    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
        log.info("{} receive message complete: {}",channel.getClass().getName(),message.getHeaders());
    }

}
