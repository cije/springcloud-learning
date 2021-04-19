package com.ce.ribbonrule.config;

import com.ce.ribbonrule.rule.CustomerRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author c__e
 * @date 2021/4/19 14:32
 */
@Configuration
public class UserServiceRule {
    @Bean
    public IRule iRule() {
        System.out.println("CustomerRule");
        return new CustomerRule();
    }
}
