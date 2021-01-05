package channels;

import interceptor.OrderInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.*;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 16:37
 * @description
 */
public class Channels {

    private static final int QUEUE_SIZE = 100;

    @Autowired
    private OrderInterceptor orderInterceptor;


    @Bean("order-request-in")
    public DirectChannel oderRequestInChannel() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.addInterceptor(orderInterceptor);
        return directChannel;
    }

    @Bean("order-paied-queue-channel")
    public QueueChannel orderPaiedQueueChannel() {
        QueueChannel queueChannel = new QueueChannel(QUEUE_SIZE);
        queueChannel.addInterceptor(orderInterceptor);
        return queueChannel;
    }

    @Bean("order-paied-urgent-queue-channel")
    public QueueChannel orderPriorityQueueChannel() {
        PriorityChannel queueChannel = new PriorityChannel(QUEUE_SIZE);
        queueChannel.addInterceptor(orderInterceptor);
        return queueChannel;
    }

    @Bean("order-pending-channel")
    public FluxMessageChannel orderPendingChannel() {
        FluxMessageChannel queueChannel = new FluxMessageChannel();
        queueChannel.addInterceptor(orderInterceptor);
        return queueChannel;
    }

    @Bean("order-cancell-channel")
    public PublishSubscribeChannel orderCancellChannel() {
        PublishSubscribeChannel queueChannel = new PublishSubscribeChannel();
        queueChannel.addInterceptor(orderInterceptor);
        return queueChannel;
    }

}
