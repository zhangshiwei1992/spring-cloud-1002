package com.zsw.userserviceprovider.zsw.hystrix;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsw.openfeign.client.OrderServiceFeignClient;

/**
 * 自定义注解 - 实现请求超时的熔断 - 测试控制类
 *
 * @author zhangshiwei
 * @since 2020年10月16日 下午6:35:14
 */
@RestController
public class ZswHystrixCommandController {
    @Autowired
    private OrderServiceFeignClient      orderServiceFeignClient;

    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/zswHystrixCommand/test")
    public String zswHystrixCommand(@PathVariable Integer num) {
        System.out.println("ZswHystrixCommandController zswHystrixCommand ------ num: " + num + ",  时间: "
                + simpleDateFormat.format(new Date()));

        if (num % 2 == 0) {
            System.out.println("num是偶数 - 不走远程访问 - 不会触发断路器逻辑");
            return "num是偶数 - 不走远程访问 - 不会触发断路器逻辑";
        }

        System.out.println("num是奇数 - 访问远程 - 订单信息服务器8082 - 如果调不通就走断路器");
        return orderServiceFeignClient.findAllList();
    }
}
