package com.xh.integration.serivceactivator;

import com.xh.integration.common.Order;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 14:04
 * @description
 */
public class MyGenericHandler implements GenericHandler<Order> {

    @Override
    public Order handle(Order payload, MessageHeaders headers) {
        payload.setPrice(1000);
        return payload;
    }
}
