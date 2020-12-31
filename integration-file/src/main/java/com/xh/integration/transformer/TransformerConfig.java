package com.xh.integration.transformer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2020/12/31 14:49
 * @description
 */
@Configuration
public class TransformerConfig {

    @Bean
    @Transformer(inputChannel = "textInChannel"
            , outputChannel = "fileWriterChannel")
    public MyTransformer myTransformer() {
        return new MyTransformer();
    }
}
