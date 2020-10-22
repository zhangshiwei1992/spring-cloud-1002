package com.zsw.exception;

import lombok.Data;

/**
 * 基础异常类
 *
 * @author zhangshiwei
 * @since 2020年10月21日 下午9:09:29
 */
@Data
public class BaseException extends RuntimeException {

    private String code;
    private String msg;

}
