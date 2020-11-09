package com.zsw.userprovider.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsw.openfeign.client.OrderFeignTestClient;

/**
 * UserController
 *
 * @author zhangshiwei
 * @since 2020年11月9日 下午9:52:34
 */
@RestController
public class UserController {
    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private OrderFeignTestClient         orderFeignTestClient;

    @RequestMapping("/test")
    public String test() {
        System.out.println("UserController test ,请求时间: " + simpleDateFormat.format(new Date()));
        return orderFeignTestClient.findAllList();
    }

}
