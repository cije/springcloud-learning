package com.ce.cloudstreamrabbitmqprovider.ccontroller;

import com.ce.cloudstreamrabbitmqprovider.provider.IMessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author c__e
 * @date 2021/4/23 10:36
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @RequestMapping("/sendMessage")
    public String send() {
        return messageProvider.send();
    }
}
