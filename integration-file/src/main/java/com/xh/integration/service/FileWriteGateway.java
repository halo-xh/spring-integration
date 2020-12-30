package com.xh.integration.service;


import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * MessagingGateway的defaultRequestChannel属性表明接口方法调用时所返回的消息要发送至给定的消息通道（message channel）。
 * 在本例中，我们声明调用writeToFile()所形成的消息应该发送至名为textInChannel的通道中。
 */
@MessagingGateway(defaultReplyChannel = "textInChannel")
public interface FileWriteGateway {

    /**
     * 对于writeToFile()方法来说，它以String类型的形式接受一个文件名，另外一个String包含了要写入文件中的文本。
     * 关于这个方法的签名，还需要注意filename参数上带有@Header。
     * 在本例中，@Header注解表明传递给filename的值应该包含在消息头信息中（通过FileHeaders.FILENAME声明，它将会被解析成file_name），
     * 而不是放到消息载荷（payload）中。
     */
    void writeToFile(@Header(FileHeaders.FILENAME) String fileName, String data);

}

