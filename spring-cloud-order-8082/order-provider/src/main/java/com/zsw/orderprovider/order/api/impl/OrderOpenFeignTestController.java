package com.zsw.orderprovider.order.api.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RestController;

import com.zsw.openfeign.dto.OrderFeignTestDto;
import com.zsw.openfeign.service.OrderFeignTestService;

/**
 * OrderServiceImpl
 *
 * @author zhangshiwei
 * @since 2020年10月10日 下午10:08:46
 */
@RestController
public class OrderOpenFeignTestController implements OrderFeignTestService {

    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String findAllList() {
        System.out.println("OrderServiceImpl findAllList : " + simpleDateFormat.format(new Date()));
        return "这就是所有的订单信息集合";
    }

    @Override
    public String findById() {
        System.out.println("OrderServiceImpl findById : " + simpleDateFormat.format(new Date()));
        return "这就是根据根据id查询到的订单信息";
    }

    @Override
    public int insertMessage(OrderFeignTestDto orderDto) {
        System.out.println("OrderServiceImpl insertMessage : " + simpleDateFormat.format(new Date()));
        return 1;
    }
}
