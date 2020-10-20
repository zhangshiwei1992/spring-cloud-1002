package com.zsw.springcloudgateway9093;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 自定义类实现RouteDefinitionRepository接口,完成路由动态配置,重启项目不丢失
 *
 * @author zhangshiwei
 * @since 2020年10月20日 上午12:51:07
 */
@Component
public class ZswRedisRouteDefinitionRepository implements RouteDefinitionRepository {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private final static String           GATEWAY_ROUTE_REDIS_KEY = "GATEWAY_ROUTE_REDIS_KEY";

    public final static SimpleDateFormat  simpleDateFormat        = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取路由信息
     *
     * @return 所有的路由配置信息
     */
    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        System.out.println(
                "ZswRedisRouteDefinitionRepository getRouteDefinitions , 请求时间: " + simpleDateFormat.format(new Date()));

        List<RouteDefinition> routeDefinitionList = new ArrayList<>();

        redisTemplate.opsForHash()
                .values(GATEWAY_ROUTE_REDIS_KEY)
                .forEach(route -> routeDefinitionList.add(JSON.parseObject(route.toString(), RouteDefinition.class)));

        return Flux.fromIterable(routeDefinitionList);
    }

    /**
     * 新增路由配置信息
     */
    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        System.out.println("ZswRedisRouteDefinitionRepository save , 请求时间: " + simpleDateFormat.format(new Date()));

        return route.flatMap(o -> {
            redisTemplate.opsForHash().put(GATEWAY_ROUTE_REDIS_KEY, o.getId(), JSON.toJSONString(o));
            return Mono.empty();
        });
    }

    /**
     * 删除路由配置信息
     *
     * @param routeId 路由routeId
     * @return 结果
     */
    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        System.out.println("ZswRedisRouteDefinitionRepository delete , 请求时间: " + simpleDateFormat.format(new Date()));

        return routeId.flatMap(o -> {
            if (redisTemplate.opsForHash().hasKey(GATEWAY_ROUTE_REDIS_KEY, routeId)) {
                redisTemplate.opsForHash().delete(GATEWAY_ROUTE_REDIS_KEY, routeId);
                return Mono.empty();
            }
            return Mono.defer(() -> Mono.error(new Exception("RouteDefinition not found : " + routeId)));
        });
    }
}
