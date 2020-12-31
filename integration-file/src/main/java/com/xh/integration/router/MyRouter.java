package com.xh.integration.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.Collection;
import java.util.Collections;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2020/12/31 15:14
 * @description
 */
public class MyRouter extends AbstractMessageRouter {

    @Autowired
    @Qualifier("qqq")
    private QueueChannel queueChannel;

    @Autowired
    @Qualifier("psps")
    private PublishSubscribeChannel publishSubscribeChannel;

    @Override
    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
        Object payload = message.getPayload();
        if (((String) payload).isEmpty()) {
            return Collections.singleton(queueChannel);
        } else {
            return Collections.singleton(publishSubscribeChannel);
        }
    }
}
