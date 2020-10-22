package com.zsw.orderserviceprovider.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsw.api.Result;
import com.zsw.orderserviceprovider.dto.OrderInfoDto;
import com.zsw.orderserviceprovider.service.IOrderService;

/**
 * TestConfigController
 *
 * @author zhangshiwei
 * @since 2020年10月10日 下午10:25:45
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Value("${server.port}")
    private String                       port;

    @Autowired
    private IOrderService                iOrderService;

    @RequestMapping("/createOrder")
    public Result<Long> createOrder(@RequestBody OrderInfoDto orderInfoDto) {
        System.out.println(port + " OrderController orders , 请求时间: " + simpleDateFormat.format(new Date()));
        return iOrderService.createOrder(orderInfoDto);
    }

}
