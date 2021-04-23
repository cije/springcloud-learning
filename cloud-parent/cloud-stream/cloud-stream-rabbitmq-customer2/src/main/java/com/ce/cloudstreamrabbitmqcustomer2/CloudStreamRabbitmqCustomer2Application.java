package com.ce.cloudstreamrabbitmqcustomer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudStreamRabbitmqCustomer2Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitmqCustomer2Application.class, args);
    }

}
