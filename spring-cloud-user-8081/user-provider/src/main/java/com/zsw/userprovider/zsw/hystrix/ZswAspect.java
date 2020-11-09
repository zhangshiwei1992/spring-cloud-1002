package com.zsw.userprovider.zsw.hystrix;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 自定义注解 - 实现请求超时的熔断 - 切面处理类 ZswHystrixCommandAspect
 *
 * @author zhangshiwei
 * @since 2020年10月16日 下午6:25:59
 */
//@Aspect
public class ZswAspect {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    //    @Pointcut(value = "@annotation(ZswHystrixCommand)")
    //    public void pointCut() {
    //    }
    //
    //    @Around(value = "pointCut()&&@annotation(zswHystrixCommand)")
    //    public Object doPointCut(final ProceedingJoinPoint joinPoint, ZswHystrixCommand zswHystrixCommand) {
    //        int timeout = zswHystrixCommand.timeout();
    //
    //        //        Featurere feature = executorService.submit(() -> {
    //        //            try {
    //        //                joinPoint.proceed();
    //        //            } catch (Throwable throwable) {
    //        //                throwable.printStackTrace();
    //        //            }
    //        //        });
    //
    //        return null;
    //    }
}
