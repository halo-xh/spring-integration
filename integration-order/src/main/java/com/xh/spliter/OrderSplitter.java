package com.xh.spliter;

import com.xh.common.Goods;
import com.xh.common.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 17:10
 * @description
 */
@Slf4j
@Component
public class OrderSplitter extends AbstractMessageSplitter {

    @Override
    protected Goods splitMessage(Message<?> message) {
        log.info("OrderSplitter splitMessage... ");
        Order order = (Order) message.getPayload();
        return Goods.builder().goodsName(order.getGoodsName()).price(order.getGoodsPrice()).build();
    }
}
