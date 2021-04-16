package com.ce.apigateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用Java Bean配置路由
 *
 * @author c__e
 * @date 2021/4/16 16:18
 */
@Configuration
public class GatewayConfig {

    @Value("${service-url.user-service}")
    private String userServiceUri;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route2",
                        r -> r.path("/user/getByUsername")
                                .uri(userServiceUri + "/user/getByUsername"))
                .build();
    }
}
