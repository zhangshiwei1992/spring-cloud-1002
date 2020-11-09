package com.zsw.openfeign.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import com.zsw.openfeign.dto.OrderFeignTestDto;
import com.zsw.openfeign.service.OrderFeignTestService;

/**
 * OrderServiceFeignClient
 *
 * @author zhangshiwei
 * @since 2020年10月10日 17:39:25
 */
@FeignClient(value = "order-service", fallback = OrderFeignTestClient.OrderServiceFeignClientFallback.class)
public interface OrderFeignTestClient extends OrderFeignTestService {

    @Component
    class OrderServiceFeignClientFallback implements OrderFeignTestClient {
        public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        @Override
        public String findAllList() {
            System.out.println("OrderServiceFeignClient OrderServiceFeignClientFallback findAllList ,  时间: "
                    + simpleDateFormat.format(new Date()));
            return "OrderServiceFeignClientFallback - findAllList - 熔断失败";
        }

        @Override
        public String findById() {
            System.out.println("OrderServiceFeignClient OrderServiceFeignClientFallback findById ,  时间: "
                    + simpleDateFormat.format(new Date()));
            return "OrderServiceFeignClientFallback - findById - 熔断失败";
        }

        @Override
        public int insertMessage(OrderFeignTestDto orderDto) {
            System.out.println("OrderServiceFeignClient OrderServiceFeignClientFallback insertMessage ,  时间: "
                    + simpleDateFormat.format(new Date()));
            return -1;
        }
    }
}
