package com.zsw.orderserviceprovider.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestConfigController
 *
 * @author zhangshiwei
 * @since 2020年10月10日 下午10:25:45
 */
@RestController
public class OrderController {
    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/orders")
    public String getEnv() {
        System.out.println("OrderController orders : " + simpleDateFormat.format(new Date()));
        return "orders-100个";
    }

}
