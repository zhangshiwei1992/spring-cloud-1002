package com.zsw.orderserviceprovider.dto;

import java.util.List;

import lombok.Data;

/**
 * OrderDto
 *
 * @author zhangshiwei
 * @since 2020年10月21日 下午8:50:42
 */
@Data
public class OrderInfoDto {

    private String           userId;
    private String           orderCode;

    private String           vehicleCode;

    private List<VehicleDto> vehicleDtoList;
}
