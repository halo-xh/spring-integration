package com.xh.integration.splitter;

import com.xh.integration.router.MyRouter;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.router.MessageRouter;
import org.springframework.integration.router.PayloadTypeRouter;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2020/12/31 15:33
 * @description
 */
@Configuration
public class MySplitterConfig {


    public MessageRouter myRouter(){
        PayloadTypeRouter payloadTypeRouter = new PayloadTypeRouter();
        payloadTypeRouter.setChannelMapping("k","KChannel");
        payloadTypeRouter.setChannelMapping("t","TChannel");
        return payloadTypeRouter;
    }
}
