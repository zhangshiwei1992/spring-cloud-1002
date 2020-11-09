package com.zsw.orderprovider.service;

import com.zsw.api.Result;
import com.zsw.orderprovider.dto.OrderInfoDto;

/**
 * IOrderService
 *
 * @author zhangshiwei
 * @since 2020年11月9日 下午2:30:13
 */
public interface IOrderService {
    /**
     * 锁定库存,查询商品确定价格,生成订单
     *
     * @param orderInfoDto 请求信息
     * @return 结果
     */
    Result<Long> createOrder(OrderInfoDto orderInfoDto);
}
