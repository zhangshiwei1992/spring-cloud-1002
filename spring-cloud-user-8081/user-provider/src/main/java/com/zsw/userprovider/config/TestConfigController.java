package com.zsw.userprovider.config;

import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.RestController;

/**
 * TestConfigController
 *
 * @author zhangshiwei
 * @since 2020年10月10日 下午10:25:45
 */
//@RefreshScope // 手动刷新配置文件内容的注解
@RestController
public class TestConfigController {
    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //    @Value("${env}")
    //    private String                       env;
    //
    //    @Value("${hello}")
    //    private String                       hello;
    //
    //    @RequestMapping("/env")
    //    public String getEnv() {
    //        System.out.println("TestConfigController getEnv : " + simpleDateFormat.format(new Date()));
    //        return env;
    //    }
    //
    //    @RequestMapping("/hello")
    //    public String hello() {
    //        System.out.println("TestConfigController hello : " + simpleDateFormat.format(new Date()));
    //        return hello;
    //    }
}
