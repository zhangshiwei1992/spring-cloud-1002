package com.zsw.orderserviceprovider.dto;

import lombok.Data;

/**
 * VehicleDto
 *
 * @author zhangshiwei
 * @since 2020年10月21日 下午8:49:31
 */
@Data
public class VehicleDto {

    private String vehicleCode;
    private String orderCode;
    private String vehicleBrandId;
    private String vehicleVendorId;
    private String vehicleSeriesId;
    private String vehicleTypeId;

}
