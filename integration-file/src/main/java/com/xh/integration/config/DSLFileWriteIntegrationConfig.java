package com.xh.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

/**
 * author  Xiao Hong
 * date  2020/12/31 0:16
 * description DSL way.
 */

@Configuration
public class DSLFileWriteIntegrationConfig {

    @Bean
    public IntegrationFlow fileWriteFlow(){
        return IntegrationFlows
                .from(MessageChannels.direct("textInChannel"))
                .<String,String>transform(String::toUpperCase)
                .channel(MessageChannels.direct("fileWriteChannel"))//这里可以不显示声明 如果channel 不存在 spring integration会自动创建
                .handle(Files.outboundAdapter(new File("/tmp/dsl/files"))
                .fileExistsMode(FileExistsMode.APPEND)
                .appendNewLine(true))
                .get();
    }
}
