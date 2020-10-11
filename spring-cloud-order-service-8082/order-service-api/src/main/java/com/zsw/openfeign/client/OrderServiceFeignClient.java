package com.zsw.openfeign.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.zsw.openfeign.service.OrderService;

/**
 * OrderServiceFeignClient
 *
 * @author zhangshiwei
 * @since 2020年10月10日 17:39:25
 */
@FeignClient("order-service")
public interface OrderServiceFeignClient extends OrderService {

}
