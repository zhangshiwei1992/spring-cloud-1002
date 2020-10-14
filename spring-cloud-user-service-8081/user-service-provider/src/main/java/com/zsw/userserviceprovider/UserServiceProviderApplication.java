package com.zsw.userserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker // 开启熔断Hystrix
@SpringBootApplication
public class UserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderApplication.class, args);
    }

}
