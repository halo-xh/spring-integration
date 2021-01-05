package gateway;

import common.Order;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 15:09
 *
 * gateway
 *
 */
@Component
@MessagingGateway(defaultRequestChannel = "order-request-in", defaultReplyChannel = "order-validate-out")
public interface OrderGateway {

    Order validateOrder(Order order);
}
