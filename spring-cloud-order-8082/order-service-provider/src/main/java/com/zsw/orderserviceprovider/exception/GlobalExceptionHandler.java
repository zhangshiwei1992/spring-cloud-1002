package com.zsw.orderserviceprovider.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zsw.api.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常处理
 *
 * @author zhangshiwei
 * @since 2020年10月21日 下午9:28:14
 */
@Slf4j
@RestControllerAdvice // 针对controller异常的拦截
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e, HttpServletRequest request) {
        log.info("handleException URL: {} ", request.getRequestURL());
        log.info("handleException URI: {} ", request.getRequestURI());
        log.info("GlobalExceptionHandler.handleException url: {} ,e: {}", request.getRequestURI(), e);
        Result<String> result = new Result<>();
        result.setValue("系统繁忙: " + e.getMessage());
        return result;
    }
}
