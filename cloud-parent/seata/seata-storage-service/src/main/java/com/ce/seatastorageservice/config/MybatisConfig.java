package com.ce.seatastorageservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author c__e
 * @date 2021/4/20 15:36
 */
@Configuration
@MapperScan(basePackages = "com.ce.seatastorageservice.mapper")
public class MybatisConfig {
}
