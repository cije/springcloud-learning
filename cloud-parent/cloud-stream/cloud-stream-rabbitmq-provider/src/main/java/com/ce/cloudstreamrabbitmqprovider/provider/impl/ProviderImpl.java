package com.ce.cloudstreamrabbitmqprovider.provider.impl;

import cn.hutool.core.lang.UUID;
import com.ce.cloudstreamrabbitmqprovider.provider.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * `@enableBinding`：定义消息的推送管道 信道channel和exchange绑定在一起
 *
 * @author c__e
 * @date 2021/4/23 10:30
 */
@EnableBinding(Source.class)
public class ProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道 操作消息中间件发送消息
     */
    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***************************serial" + serial);
        return serial;
    }
}
