package com.xh.spliter;

import com.xh.common.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 16:20
 * @description
 */
@Slf4j
@Component
public class OrderListSplitter {

    @Bean
    @Splitter(inputChannel = "order-request-start",outputChannel = "order-request-in")
    public List<Order> orderList(List<Order> orders){
        log.info("OrderListSplitter orderList");
        return orders;
    }
}
