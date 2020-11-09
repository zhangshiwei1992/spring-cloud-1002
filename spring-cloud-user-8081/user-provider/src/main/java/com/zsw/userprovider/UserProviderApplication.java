package com.zsw.userprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.zsw.userprovider", "com.zsw.openfeign.client" }) // openFeign客户端放在了服务提供方,需要扫描到交给spring管理
@EnableFeignClients(basePackages = "com.zsw.openfeign.client") // openFeign客户端
//@EnableCircuitBreaker // 开启熔断Hystrix
@SpringBootApplication
public class UserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class, args);
    }

}
