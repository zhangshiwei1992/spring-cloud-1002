package com.zsw.springcloudgateway9093;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * GateWay 基于redis 实现令牌桶限流 --- 基于ip请求地址作为key进行限流的判断
 *
 * @author zhangshiwei
 * @since 2020年10月19日 上午12:32:35
 */
@Component
public class IpAddressKeyResolver implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}
