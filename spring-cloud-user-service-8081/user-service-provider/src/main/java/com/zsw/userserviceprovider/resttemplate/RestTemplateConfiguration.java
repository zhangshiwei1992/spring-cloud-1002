package com.zsw.userserviceprovider.resttemplate;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate自动注入
 *
 * @author zhangshiwei
 * @since 2020年10月13日 下午5:36:24
 */
@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate buildRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        System.out.println("====== RestTemplateConfiguration buildRestTemplate ======");
        return restTemplateBuilder.build();
    }
}
