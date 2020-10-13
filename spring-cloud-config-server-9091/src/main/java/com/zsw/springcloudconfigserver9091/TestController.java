package com.zsw.springcloudconfigserver9091;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author zhangshiwei
 * @since 2020年10月12日 下午2:14:22
 */
@RestController
public class TestController {

    @Value("${spring.application.name}")
    private String name;

    @RequestMapping("/name")
    public String getName() {
        return name;
    }
}
