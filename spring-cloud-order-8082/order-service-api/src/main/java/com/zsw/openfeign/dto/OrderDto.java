package com.zsw.openfeign.dto;

/**
 * OrderDto
 *
 * @author zhangshiwei
 * @since 2020年10月10日 17:39:25
 */
public class OrderDto {

    String orderCode;

    String content;

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "OrderDto{" + "orderCode='" + orderCode + '\'' + ", content='" + content + '\'' + '}';
    }
}
