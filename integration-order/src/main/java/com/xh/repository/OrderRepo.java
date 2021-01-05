package com.xh.repository;

import com.xh.common.Goods;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 14:42
 * @description
 */
@Slf4j
public class OrderRepo {

    public Goods save(Goods goods){
        log.info("mock save goods {} into db.", goods);
        return goods;
    }
}
