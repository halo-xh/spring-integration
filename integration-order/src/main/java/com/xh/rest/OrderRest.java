package com.xh.rest;

import com.xh.common.Order;
import com.xh.common.OrderType;
import com.xh.gateway.StartGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 15:21
 * @description
 */

@RestController
public class OrderRest {

    @Autowired
    private StartGateway startGateway;

    public String createOrder(@PathVariable("id")String id){
        Order s = Order.builder()
                .createDate(new Date())
                .uuid(UUID.randomUUID().toString())
                .goodsId(id)
                .type(OrderType.CANCELL)
                .goodsName("s")
                .build();
        Order s1 = Order.builder()
                .createDate(new Date())
                .uuid(UUID.randomUUID().toString())
                .goodsId(id)
                .type(OrderType.PAIED)
                .goodsName("s")
                .build();
        Order s2 = Order.builder()
                .createDate(new Date())
                .uuid(UUID.randomUUID().toString())
                .goodsId(id)
                .type(OrderType.PENDING_PAY)
                .goodsName("s")
                .build();
        Order s3 = Order.builder()
                .createDate(new Date())
                .uuid(UUID.randomUUID().toString())
                .goodsId(id)
                .type(OrderType.URGENT)
                .goodsName("s")
                .build();
        Order s4 = Order.builder()
                .createDate(new Date())
                .uuid(UUID.randomUUID().toString())
                .goodsId(id)
                .type(OrderType.URGENT)
                .goodsName("s")
                .build();
        startGateway.validateOrder(Arrays.asList(s,s1,s2,s3,s4));
        return s.toString();
    }

}
