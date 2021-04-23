package com.ce.cloudstreamrabbitmqprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudStreamRabbitmqProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitmqProviderApplication.class, args);
    }

}
