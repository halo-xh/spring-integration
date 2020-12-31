package com.xh.integration.filter;

import org.springframework.integration.core.GenericSelector;
import org.springframework.stereotype.Component;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2020/12/31 10:27
 * @description 实现 GenericSelector 接口 完成filter功能
 */
@Component("trueFilter")
public class MyFilter implements GenericSelector<String> {


    @Override
    public boolean accept(String source) {
        return true;
    }
}
