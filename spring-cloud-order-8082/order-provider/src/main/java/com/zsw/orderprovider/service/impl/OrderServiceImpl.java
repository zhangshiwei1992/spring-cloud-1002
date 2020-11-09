package com.zsw.orderprovider.service.impl;

import org.springframework.stereotype.Service;

import com.zsw.api.Result;
import com.zsw.orderprovider.dto.OrderInfoDto;
import com.zsw.orderprovider.service.IOrderService;

/**
 * OrderServiceImpl
 *
 * @author zhangshiwei
 * @since 2020年10月22日 下午4:13:29
 */
@Service
public class OrderServiceImpl implements IOrderService {
    /**
     * 锁定库存,查询商品确定价格,生成订单
     *
     * @param orderInfoDto 请求信息
     * @return 结果
     */
    @Override
    public Result<Long> createOrder(OrderInfoDto orderInfoDto) {
        Result<Long> result = new Result<>();
        return result;
    }

}
