package com.xh.gateway;

import com.xh.common.Order;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 16:18
 * @description
 */
@Component
@MessagingGateway(defaultRequestChannel = "order-request-start")
public interface StartGateway {

    Order validateOrder(List<Order> orders);

}
