package com.xh.gateway;

import com.xh.common.Order;
import com.xh.common.OrderType;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 15:09
 *
 * com.xh.gateway
 *
 */
@Component
@MessagingGateway(defaultRequestChannel = "order-request-in", defaultReplyChannel = "order-validate-out")
public interface OrderGateway {

    Order validateOrder(@Header("type")OrderType type, Order order);
}
