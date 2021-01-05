package com.xh.filter;

import com.xh.common.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.core.GenericSelector;
import org.springframework.stereotype.Component;


/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 14:55
 * @description
 */
@Slf4j
@Component
public class DeadOrderFilter implements GenericSelector<Order> {

    @Override
    public boolean accept(Order source) {
        log.info(" Filter ... ");
        return source.getCreateDate() != null;
    }
}
