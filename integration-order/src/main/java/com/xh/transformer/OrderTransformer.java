package com.xh.transformer;

import com.xh.common.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.stereotype.Component;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 16:28
 * @description
 */
@Slf4j
@Component
public class OrderTransformer implements GenericTransformer<Order,Order> {

    @Override
    public Order transform(Order source) {
        log.info("OrderTransformer.transform ");
        source.setGoodsId(source.getGoodsId()+"ts");
        return source;
    }
}
