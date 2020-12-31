package com.xh.integration.transformer;

import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.stereotype.Component;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2020/12/31 14:47
 * @description
 */

public class MyTransformer implements GenericTransformer<String, String> {

    @Override
    public String transform(String source) {
        return source.toUpperCase();
    }
}
