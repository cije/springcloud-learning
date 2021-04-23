package com.ce.cloudstreamrabbitmqcustomer1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author c__e
 * @date 2021/4/23 14:16
 */
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String port;

    /**
     * 监听队列，用于消费者队列的消息接收
     */
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者1号，0------>接收到消息：" + message.getPayload() + "\t port:" + port);
    }

}
