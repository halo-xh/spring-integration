package com.xh.config;

import com.xh.filter.DeadOrderFilter;
import com.xh.gateway.OrderGateway;
import com.xh.serviceactivator.GoodsStoreActivator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import com.xh.transformer.OrderTransformer;
import com.xh.router.OrderRouter;
import com.xh.spliter.OrderSplitter;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 15:10
 *
 * 配置类
 *
 */
@Configuration
public class OrderIntegrationConfig {

    @Autowired
    @Qualifier("order-request-start")
    private DirectChannel directChannel;

    @Autowired
    private OrderGateway orderGateway;

    @Autowired
    private DeadOrderFilter deadOrderFilter;

    @Autowired
    private OrderRouter orderRouter;

    @Autowired
    private OrderSplitter orderSplitter;

    @Autowired
    private OrderTransformer orderTransformer;

    @Autowired
    private GoodsStoreActivator goodsStoreActivator;

    @Bean
    public IntegrationFlow orderFlow() {
        return IntegrationFlows.from(directChannel)
                .handle(goodsStoreActivator)
               .route(orderRouter)
                .filter(deadOrderFilter)
                .split(orderSplitter)
                .transform(orderTransformer)
                .get();
    }
}
