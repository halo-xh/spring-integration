package com.xh.integration.channel;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2020/12/31 15:18
 * @description
 */
public class MyChannelConfig {

    @Bean("qqq")
    public QueueChannel queueChannel(){
        return new QueueChannel(100);
    }

    @Bean("psps")
    public PublishSubscribeChannel publishSubscribeChannel(){
        ///**
        //	 * Create a PublishSubscribeChannel that will use an {@link Executor}
        //	 * to invoke the handlers. If this is null, each invocation will occur in
        //	 * the message sender's thread.
        //	 * @param executor The executor.
        //	 */
        //	public PublishSubscribeChannel(@Nullable Executor executor) {
        //		super(executor);
        //		this.dispatcher = new BroadcastingDispatcher(executor);
        //	}

        return new PublishSubscribeChannel();
    }



}
