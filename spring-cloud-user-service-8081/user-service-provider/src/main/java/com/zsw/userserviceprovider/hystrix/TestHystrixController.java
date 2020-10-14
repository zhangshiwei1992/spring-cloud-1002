package com.zsw.userserviceprovider.hystrix;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * HystrixController
 *
 * @author zhangshiwei
 * @since 2020年10月13日 下午5:35:22
 */
@RestController
public class TestHystrixController {

    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private RestTemplate                 restTemplate;

    @HystrixCommand(commandProperties = { @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50") }, fallbackMethod = "zswUserFallback") // 请求失败触发的方法
    @RequestMapping("/order/{num}")
    public String queryOrder(@PathVariable Integer num) {
        System.out.println("TestHystrixController queryOrder ------ num: " + num + ",  时间: "
                + simpleDateFormat.format(new Date()));

        if (num % 2 == 0) {
            System.out.println("num是偶数 - 不走远程访问 - 不会触发断路器逻辑");
            return "num是偶数 - 不走远程访问 - 不会触发断路器逻辑";
        }

        System.out.println("num是奇数 - 访问远程 - 订单信息服务器8082 - 如果调不通就走断路器");
        return restTemplate.getForObject("http://127.0.0.1:8082/orders", String.class);
    }

    /**
     * 回退方案(降级处理方案)
     *
     * @param num 请求参数
     * @return 结果
     */
    public String zswUserFallback(Integer num) {
        // 可以在此做兜底的数据处理,例如从广告服务器上查询最新的广告失败了,可以返回固定的广告信息
        System.out.println("TestHystrixController zswUserFallback ------ num: " + num + "  时间: "
                + simpleDateFormat.format(new Date()));
        return "zswUserFallback - 回退方案 - 请求失败!!!";
    }

}
