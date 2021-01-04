package com.xh.integration.gateway;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 14:28
 * @description
 */

@Component
@MessagingGateway(defaultRequestChannel = "in", defaultReplyChannel = "out")
public interface MyGateWay {

    /**
     * fakeMethod()被调用的时候，给定的 Object 会发布到集成流中，进入名为 in 的通道。
     * 不管流是如何定义的或者它都干了些什么，当数据进入名为 out 的通道时，它将会从 fakeMethod 方法返回。
     */
    Object fakeMethod(Object in);

}
