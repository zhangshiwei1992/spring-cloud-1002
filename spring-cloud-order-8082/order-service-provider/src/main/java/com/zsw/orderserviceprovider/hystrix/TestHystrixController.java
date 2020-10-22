package com.zsw.orderserviceprovider.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * HystrixController
 *
 * @author zhangshiwei
 * @since 2020年10月13日 下午5:35:22
 */
@RestController
public class TestHystrixController {

    @Autowired
    private RestTemplate restTemplate;

}
