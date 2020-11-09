package com.zsw.userprovider.hystrix;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    //    /**
    //     * 熔断触发降级 - 请求失败
    //     *
    //     * @param num 个数
    //     * @return 结果
    //     */
    //    @HystrixCommand(fallbackMethod = "zswHystrixFallback", commandProperties = {
    //            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
    //            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
    //            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
    //            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50") })
    //    @RequestMapping("/order/{num}")
    //    public String queryOrder(@PathVariable Integer num) {
    //        System.out.println("TestHystrixController queryOrder ------ num: " + num + ",  时间: "
    //                + simpleDateFormat.format(new Date()));
    //
    //        if (num % 2 == 0) {
    //            System.out.println("num是偶数 - 不走远程访问 - 不会触发断路器逻辑");
    //            return "num是偶数 - 不走远程访问 - 不会触发断路器逻辑";
    //        }
    //
    //        System.out.println("num是奇数 - 访问远程 - 订单信息服务器8082 - 如果调不通就走断路器");
    //        return restTemplate.getForObject("http://127.0.0.1:8082/getOrder", String.class);
    //    }
    //
    //    /**
    //     * 熔断触发降级 - 回退方案(降级处理方案)
    //     *
    //     * @param num 请求参数
    //     * @return 结果
    //     */
    //    public String zswHystrixFallback(Integer num) {
    //        // 可以在此做兜底的数据处理,例如从广告服务器上查询最新的广告失败了,可以返回固定的广告信息
    //        System.out.println("TestHystrixController zswHystrixFallback ------ num: " + num + "  时间: "
    //                + simpleDateFormat.format(new Date()));
    //        return "熔断触发降级 - zswHystrixFallback - 回退方案 - 请求失败!!!";
    //    }
    //
    //    /**
    //     * 请求超时 - 触发降级 (默认的timeoutInMilliseconds , 是1000 即 1s, 1秒钟远程连接还未响应就会触发熔断)
    //     *
    //     * @param num 个数
    //     * @return 结果
    //     */
    //    @HystrixCommand(fallbackMethod = "zswTimeoutFallback", commandProperties = {
    //            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"), })
    //    @RequestMapping("/queryOrderTimeout/{num}")
    //    public String queryOrderTimeout(@PathVariable Integer num) {
    //        System.out.println("TestHystrixController queryOrderTimeout ------ num: " + num + ",  时间: "
    //                + simpleDateFormat.format(new Date()));
    //
    //        if (num % 2 == 0) {
    //            System.out.println("num是偶数 - 不走远程访问 - 不会触发断路器逻辑");
    //            return "num是偶数 - 不走远程访问 - 不会触发断路器逻辑";
    //        }
    //
    //        System.out.println("num是奇数 - 访问远程 - 订单信息服务器8082 - 如果调不通就走断路器");
    //        return restTemplate.getForObject("http://127.0.0.1:8082/getOrderTimeOut", String.class);
    //    }
    //
    //    /**
    //     * 请求超时触发降级 - 回退方案(降级处理方案)
    //     *
    //     * @param num 请求参数
    //     * @return 结果
    //     */
    //    public String zswTimeoutFallback(Integer num) {
    //        // 可以在此做兜底的数据处理,例如从广告服务器上查询最新的广告失败了,可以返回固定的广告信息
    //        System.out.println("TestHystrixController zswTimeoutFallback ------ num: " + num + "  时间: "
    //                + simpleDateFormat.format(new Date()));
    //        return "请求超时触发降级 - zswTimeoutFallback - 回退方案 - 请求失败!!!";
    //    }
    //
    //    /**
    //     * 信号量隔离实现<br/>
    //     * 不会使用Hystrix管理的线程池处理请求。使用容器（Tomcat）的线程处理请求逻辑。<br/>
    //     * 不涉及线程切换，资源调度，上下文的转换等，相对效率高。<br/>
    //     * 信号量隔离也会启动熔断机制。如果请求并发数超标，则触发熔断，返回fallback数据。<br/>
    //     * commandProperties - 命令配置，HystrixPropertiesManager中的常量或字符串来配置。<br/>
    //     * execution.isolation.strategy - 隔离的种类，<br/>
    //     * 隔离的种类可选值只有THREAD（线程池隔离）和 SEMAPHORE（信号量隔离）。默认是THREAD线程池隔离。 <br/>
    //     * 设置信号量隔离后，线程池相关配置失效。<br/>
    //     * execution.isolation.semaphore.maxConcurrentRequests - 信号量最大并发数。<br/>
    //     * 信号量最大并发数默认值是10; 常见配置500~1000。 <br/>
    //     * 如果并发请求超过配置，其他请求进入fallback逻辑。
    //     */
    //    @HystrixCommand(fallbackMethod = "semaphoreQuarantineFallback", commandProperties = {
    //            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY, value = "SEMAPHORE"), // 信号量隔离
    //            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value = "100") }) // 信号量最大并发数
    //    @RequestMapping("/queryOrderBySemaphore/{num}")
    //    public String queryOrderSemaphore(@PathVariable Integer num) {
    //        System.out.println("TestHystrixController queryOrderSemaphore ------ num: " + num + ",  时间: "
    //                + simpleDateFormat.format(new Date()));
    //
    //        if (num % 2 == 0) {
    //            System.out.println("num是偶数 - 不走远程访问 - 不会触发断路器逻辑");
    //            return "num是偶数 - 不走远程访问 - 不会触发断路器逻辑";
    //        }
    //
    //        System.out.println("num是奇数 - 访问远程 - 订单信息服务器8082 - 如果调不通就走断路器");
    //        return restTemplate.getForObject("http://127.0.0.1:8082/getOrder", String.class);
    //    }
    //
    //    /**
    //     * 信号量隔离触发降级 - 回退方案(降级处理方案)
    //     *
    //     * @param num 请求参数
    //     * @return 结果
    //     */
    //    public String semaphoreQuarantineFallback(Integer num) {
    //        // 可以在此做兜底的数据处理,例如从广告服务器上查询最新的广告失败了,可以返回固定的广告信息
    //        System.out.println("TestHystrixController semaphoreQuarantineFallback ------ num: " + num + "  时间: "
    //                + simpleDateFormat.format(new Date()));
    //        return "信号量隔离触发降级 - semaphoreQuarantineFallback - 回退方案 - 请求失败!!!";
    //    }
    //
    //    /**
    //     * 线程池隔离 - 触发降级
    //     *
    //     * @param num 个数
    //     * @return 结果
    //     */
    //    @HystrixCommand(groupKey = "order-service", commandKey = "queryOrderByThreadPool", threadPoolKey = "order-service", threadPoolProperties = {
    //            @HystrixProperty(name = "coreSize", value = "30"), //线程池大小
    //            @HystrixProperty(name = "maxQueueSize", value = "100"), //最大队列长度
    //            @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"), //线程存活时间
    //            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15")//拒绝请求
    //    }, fallbackMethod = "fallbackByThreadPool")
    //    @RequestMapping("/queryOrderByThreadPool/{num}")
    //    public String queryOrderByThreadPool(@PathVariable Integer num) {
    //        System.out.println("TestHystrixController queryOrderByThreadPool ------ num: " + num + ",  时间: "
    //                + simpleDateFormat.format(new Date()));
    //
    //        if (num % 2 == 0) {
    //            System.out.println("num是偶数 - 不走远程访问 - 不会触发断路器逻辑");
    //            return "num是偶数 - 不走远程访问 - 不会触发断路器逻辑";
    //        }
    //
    //        System.out.println("num是奇数 - 访问远程 - 订单信息服务器8082 - 如果调不通就走断路器");
    //        return restTemplate.getForObject("http://127.0.0.1:8082/getOrder", String.class);
    //    }
    //
    //    /**
    //     * 线程池隔离触发降级 - 回退方案(降级处理方案)
    //     *
    //     * @param num 请求参数
    //     * @return 结果
    //     */
    //    public String fallbackByThreadPool(Integer num) {
    //        // 可以在此做兜底的数据处理,例如从广告服务器上查询最新的广告失败了,可以返回固定的广告信息
    //        System.out.println("TestHystrixController fallbackByThreadPool ------ num: " + num + "  时间: "
    //                + simpleDateFormat.format(new Date()));
    //        return "信号量隔离触发降级 - fallbackByThreadPool - 回退方案 - 请求失败!!!";
    //    }

}
