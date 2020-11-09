package com.zsw.userprovider.hystrix;

import org.springframework.web.bind.annotation.RestController;

/**
 * Hystrix配合openFeign使用
 *
 * @author zhangshiwei
 * @since 2020年10月14日 下午2:09:50
 */
@RestController
public class HystrixOpenFeignController {

    //    @Autowired
    //    private OrderFeignTestClient         orderServiceFeignClient;
    //
    //    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //
    //    @RequestMapping("/findAllOrderList/{num}")
    //    public String queryOrderSemaphore(@PathVariable Integer num) {
    //        System.out.println("HystrixOpenFeignController queryOrderSemaphore ------ num: " + num + ",  时间: "
    //                + simpleDateFormat.format(new Date()));
    //
    //        if (num % 2 == 0) {
    //            System.out.println("num是偶数 - 不走远程访问 - 不会触发断路器逻辑");
    //            return "num是偶数 - 不走远程访问 - 不会触发断路器逻辑";
    //        }
    //
    //        System.out.println("num是奇数 - 访问远程 - 订单信息服务器8082 - 如果调不通就走断路器");
    //        return orderServiceFeignClient.findAllList();
    //    }
}
