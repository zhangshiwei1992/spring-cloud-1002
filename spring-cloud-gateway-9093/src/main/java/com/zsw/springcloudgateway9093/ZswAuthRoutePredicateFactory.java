package com.zsw.springcloudgateway9093;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;

/**
 * 自定义断言工厂 - 校验用户请求是否携带固定参数,根据其值校验登录权限
 *
 * @author zhangshiwei
 * @since 2020年10月20日 上午10:20:20
 */
@Component
public class ZswAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<ZswAuthRoutePredicateFactory.Config> {
    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ZswAuthRoutePredicateFactory() {
        super(Config.class);
    }

    private static final String NAME_KEY = "name";

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(NAME_KEY);
    }

    @Override
    public Predicate<ServerWebExchange> apply(ZswAuthRoutePredicateFactory.Config config) {
        System.out.println("ZswAuthRoutePredicateFactory apply , 请求时间: " + simpleDateFormat.format(new Date()));

        return (exchange -> {
            HttpHeaders headers = exchange.getRequest().getHeaders();
            List<String> headerList = headers.get(config.getName());
            System.out.println("headerList: " + headerList);
            // todo 根据headerList中取出的值, 比如mic,去redis查询是否存在,如果能够取得值,那就是登录授权了且未过时
            return !CollectionUtils.isEmpty(headerList);
        });
    }

    public static class Config {

        private String name;

        private String regexp;

        public String getName() {
            return name;
        }

        public ZswAuthRoutePredicateFactory.Config setName(String name) {
            this.name = name;
            return this;
        }

        public String getRegexp() {
            return regexp;
        }

        public ZswAuthRoutePredicateFactory.Config setRegexp(String regexp) {
            this.regexp = regexp;
            return this;
        }

    }
}
