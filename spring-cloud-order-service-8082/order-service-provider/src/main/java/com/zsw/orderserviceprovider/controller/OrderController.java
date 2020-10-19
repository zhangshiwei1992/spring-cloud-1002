package com.zsw.orderserviceprovider.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${server.port}")
    private String                       port;

    @RequestMapping("/orders")
    public String orders() {
        System.out.println(port + " OrderController orders , 请求时间: " + simpleDateFormat.format(new Date()));
        return "orders , 端口: " + port;
    }

    @RequestMapping("/getOrder")
    public String getOrder() {
        System.out.println("OrderController getOrder , 请求时间: " + simpleDateFormat.format(new Date()));
        return "orders-100个";
    }

    @RequestMapping("/getOrderTimeOut")
    public String getOrderTimeOut() {
        System.out.println("OrderController getOrderTimeOut , 请求时间: " + simpleDateFormat.format(new Date()));
        try {
            System.out.println("OrderController getOrderTimeOut 开始沉睡5秒 , 请求时间: " + simpleDateFormat.format(new Date()));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "orders-100个";
    }

}
