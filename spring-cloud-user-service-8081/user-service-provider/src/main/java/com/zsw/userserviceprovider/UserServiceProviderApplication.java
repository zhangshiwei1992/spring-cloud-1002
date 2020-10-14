package com.zsw.userserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.zsw.userserviceprovider", "com.zsw.openfeign.client" }) // openFeign客户端放在了服务提供方,需要扫描到交给spring管理
@EnableFeignClients(basePackages = "com.zsw.openfeign.client") // openFeign客户端
@EnableCircuitBreaker // 开启熔断Hystrix
@SpringBootApplication
public class UserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderApplication.class, args);
    }

}
