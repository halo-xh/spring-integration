package spliter;

import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 17:10
 * @description
 */
public class OrderSpliter extends AbstractMessageSplitter {


    @Override
    protected Object splitMessage(Message<?> message) {
        return null;
    }
}
