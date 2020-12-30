package com.xh.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.MessageChannel;

import java.io.File;

/**
 * author  Xiao Hong
 * date  2020/12/31 0:07
 * description
 */
@Configuration
public class FileWriteIntegrationConfig {

    @Bean
    @Transformer(inputChannel = "textInChannel", outputChannel = "fileWriterChannel")
    public GenericTransformer<String, String> upperCaseTransformer() {
        return String::toUpperCase;
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public FileWritingMessageHandler fileWritingMessageHandler() {
        FileWritingMessageHandler fileWritingMessageHandler =
                new FileWritingMessageHandler(new File("/tmp/java/files"));
        //FileWritingMessageHandler bean的一个独特之处在于它调用了setExpectReply(false)方法，
        // 通过这个方法能够告知服务激活器（serviceactivator）不要期望会有答复通道（replychannel，通过这样的通道，我们可以将某个值返回到流中的上游组件）。
        // 如果我们不调用setExpectReply()，文件写入bean的默认值是true。
        // 尽管管道的功能和预期一样，但是在日志中会看到一些错误日志，提示我们没有设置答复通道。
        fileWritingMessageHandler.setExpectReply(false);
        fileWritingMessageHandler.setFileExistsMode(FileExistsMode.APPEND);
        fileWritingMessageHandler.setAppendNewLine(true);
        return fileWritingMessageHandler;
    }

    /**
     * 我们在这里没有必要显式声明通道。如果名为textInChannel和fileWriterChannel的bean不存在，
     * 那么这两个通道将会自动创建。但是，如果你想要更加精确地控制通道配置，那么可以按照如下的方式显式构建这些bean：
     */

    @Bean
    public MessageChannel textInChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriterChannel(){
        return new DirectChannel();
    }

}
