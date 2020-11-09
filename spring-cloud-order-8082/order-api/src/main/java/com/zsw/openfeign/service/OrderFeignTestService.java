package com.zsw.openfeign.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zsw.openfeign.dto.OrderFeignTestDto;

/**
 * MessageService
 *
 * @author zhangshiwei
 * @since 2020年10月10日 17:39:25
 */
public interface OrderFeignTestService {

    @RequestMapping("/findAllList")
    String findAllList();

    @RequestMapping("/findById")
    String findById();

    @RequestMapping("/insert")
    int insertMessage(@RequestBody OrderFeignTestDto orderDto);
}
