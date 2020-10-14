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

    /**
     * 熔断触发降级 - 请求失败
     *
     * @param num 个数
     * @return 结果
     */
    @HystrixCommand(fallbackMethod = "zswHystrixFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50") })
    @RequestMapping("/order/{num}")
    public String queryOrder(@PathVariable Integer num) {
        System.out.println("TestHystrixController queryOrder ------ num: " + num + ",  时间: "
                + simpleDateFormat.format(new Date()));

        if (num % 2 == 0) {
            System.out.println("num是偶数 - 不走远程访问 - 不会触发断路器逻辑");
            return "num是偶数 - 不走远程访问 - 不会触发断路器逻辑";
        }

        System.out.println("num是奇数 - 访问远程 - 订单信息服务器8082 - 如果调不通就走断路器");
        return restTemplate.getForObject("http://127.0.0.1:8082/getOrder", String.class);
    }

    /**
     * 熔断触发降级 - 回退方案(降级处理方案)
     *
     * @param num 请求参数
     * @return 结果
     */
    public String zswHystrixFallback(Integer num) {
        // 可以在此做兜底的数据处理,例如从广告服务器上查询最新的广告失败了,可以返回固定的广告信息
        System.out.println("TestHystrixController zswHystrixFallback ------ num: " + num + "  时间: "
                + simpleDateFormat.format(new Date()));
        return "熔断触发降级 - zswHystrixFallback - 回退方案 - 请求失败!!!";
    }

    /**
     * 请求超时 - 触发降级 (默认的timeoutInMilliseconds , 是1000 即 1s, 1秒钟远程连接还未响应就会触发熔断)
     *
     * @param num 个数
     * @return 结果
     */
    @HystrixCommand(fallbackMethod = "zswTimeoutFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"), })
    @RequestMapping("/queryOrderTimeout/{num}")
    public String queryOrderTimeout(@PathVariable Integer num) {
        System.out.println("TestHystrixController queryOrderTimeout ------ num: " + num + ",  时间: "
                + simpleDateFormat.format(new Date()));

        if (num % 2 == 0) {
            System.out.println("num是偶数 - 不走远程访问 - 不会触发断路器逻辑");
            return "num是偶数 - 不走远程访问 - 不会触发断路器逻辑";
        }

        System.out.println("num是奇数 - 访问远程 - 订单信息服务器8082 - 如果调不通就走断路器");
        return restTemplate.getForObject("http://127.0.0.1:8082/getOrderTimeOut", String.class);
    }

    /**
     * 请求超时触发降级 - 回退方案(降级处理方案)
     *
     * @param num 请求参数
     * @return 结果
     */
    public String zswTimeoutFallback(Integer num) {
        // 可以在此做兜底的数据处理,例如从广告服务器上查询最新的广告失败了,可以返回固定的广告信息
        System.out.println("TestHystrixController zswTimeoutFallback ------ num: " + num + "  时间: "
                + simpleDateFormat.format(new Date()));
        return "请求超时触发降级 - zswTimeoutFallback - 回退方案 - 请求失败!!!";
    }

}
