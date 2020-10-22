package com.zsw.orderserviceprovider.service;

import com.zsw.api.Result;
import com.zsw.orderserviceprovider.dto.OrderInfoDto;

/**
 * OrderService
 *
 * @author zhangshiwei
 * @since 2020年10月22日 下午4:13:03
 */
public interface IOrderService {
    /**
     * 订单新增
     *
     * @param orderInfoDto 请求信息
     * @return 处理结果
     */
    Result<Long> createOrder(OrderInfoDto orderInfoDto);
}
