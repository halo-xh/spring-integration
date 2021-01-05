package com.xh.serviceactivator;

import com.xh.common.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 14:33
 * @description
 */
@Slf4j
@Component
public class GoodsStoreActivator implements GenericHandler<Goods> {

    @Override
    public Goods handle(Goods goods, MessageHeaders headers) {
        log.info("mock save goods {} into db.", goods);
        return goods;
    }
}
