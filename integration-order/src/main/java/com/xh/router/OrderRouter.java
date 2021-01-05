package com.xh.router;

import com.xh.common.OrderType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.FluxMessageChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 16:17
 * @description com.xh.router.
 */
@Slf4j
@Component
public class OrderRouter extends AbstractMessageRouter {

    @Autowired
    @Qualifier("order-paied-queue-channel")
    QueueChannel orderPaiedQueueChannel;

    @Autowired
    @Qualifier("order-paied-urgent-queue-channel")
    QueueChannel orderPriorityQueueChannel;

    @Autowired
    @Qualifier("order-pending-channel")
    FluxMessageChannel orderPendingChannel;

    @Autowired
    @Qualifier("order-cancell-channel")
    PublishSubscribeChannel orderCancellChannel;


    @Override
    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
        log.info("OrderRouter determineTargetChannels");
        OrderType type = (OrderType) (message.getHeaders()).get("type");
        assert type != null;
        switch (type) {
            case PAIED:
                return Collections.singleton(orderPaiedQueueChannel);
            case URGENT:
                return Arrays.asList(new MessageChannel[]{orderPaiedQueueChannel, orderPriorityQueueChannel});
            case CANCELL:
                return Collections.singleton(orderCancellChannel);
            default:
                return Collections.singleton(orderPendingChannel);
        }
    }
}
