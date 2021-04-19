package com.ce.ribbonservice.config;

import com.ce.ribbonrule.config.UserServiceRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author c__e
 * @date 2021/4/15 9:59
 */
@Configuration
@RibbonClients({
        @RibbonClient(name = "user-service", configuration = UserServiceRule.class)
})
public class RibbonConfig {

    @LoadBalanced
    @Bean("restTemplate1")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean("restTemplate2")
    public RestTemplate restTemplate1() {
        return new RestTemplate();
    }
}
