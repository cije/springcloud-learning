package com.ce.feignservice.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author c__e
 * @date 2021/4/15 16:10
 */
@Configuration
public class FeignConfig {

    /**
     * <h2>日志级别</h2>
     * <ul>
     * <li>NONE：默认的，不显示任何日志；</li>
     * <li>BASIC：仅记录请求方法、URL、响应状态码及执行时间；</li>
     * <li>HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息；</li>
     * <li>FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。</li>
     * </ul>
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.HEADERS;
    }
}
