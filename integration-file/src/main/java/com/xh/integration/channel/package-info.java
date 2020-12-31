/*

通道（channel）：将消息从一个元素传递到另一个元素

•PublishSubscribeChannel：
    发送到PublishSubscribeChannel的消息会被传递到一个或多个消费者中。如果有多个消费者，它们都会接收到消息。
•QueueChannel：
    发送到QueueChannel的消息会存储到一个队列中，会按照先进先出（First In First Out，FIFO）的方式被拉取出来。
    如果有多个消费者，只有其中的一个消费者会接收到消息。
•PriorityChannel：
    与QueueChannel类似，但它不是FIFO的方式，而是会基于消息的priority头信息被消费者拉取出来。
•RendezvousChannel：
    与QueueChannel类似，但是发送者会一直阻塞通道，直到消费者接收到消息为止，实际上会同步发送者和消费者。
•DirectChannel：
    与PublishSubscribeChannel类似，但是消息只会发送至一个消费者，它会在与发送者相同的线程中调用消费者。
    这种方式允许事务跨通道。
•ExecutorChannel：
    类似于DirectChannel，但是消息分发是通过TaskExecutor实现的，这样会在与发送者独立的线程中执行。
    这种通道类型不支持事务跨通道。
•FluxMessageChannel：
    反应式流的发布者消息通道，基于Reactor项目的Flux。

 */