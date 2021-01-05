package com.xh.serviceactivator;

import com.xh.common.Goods;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.handler.GenericHandler;
import com.xh.repository.OrderRepo;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 14:40
 * @description
 */
public class ServiceActivators {

    @Bean
    @ServiceActivator(inputChannel = "goods-in",outputChannel = "goods-out")
    public GenericHandler<Goods> storeGoodsService(OrderRepo orderRepo){
        return ((payload, headers) -> orderRepo.save(payload));
    }

}

