package com.zsw.userserviceprovider.zsw.hystrix;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 - 实现请求超时的熔断
 *
 * @author zhangshiwei
 * @since 2020年10月16日 下午5:51:19
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZswHystrixCommand {
    /**
     * 请求超时时间 - 默认1000ms
     */
    int timeout() default 1000;

    /**
     * 请求超时处理方法
     *
     * @return 处理结果
     */
    String fallback() default "";
}
