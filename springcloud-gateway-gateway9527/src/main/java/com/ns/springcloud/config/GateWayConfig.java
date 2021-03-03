package com.ns.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-03-03 9:32
 */
@Configuration  //配置文件上加的注解
public class GateWayConfig {
    /**
     * 代码中配置网关
     *
     * 配置了一个id为route-name的路由规则，
     * 当访问地址http://localhost:9527/guonei 时会自动转发到地址:
     * http://news.baidu.com/guonei
     */

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_ns", r -> r.path("/guonei")//映射到 http://news.baidu.com/guonei
                .uri("http://news.baidu.com/guonei"))
                .build();
        return routes.build();
    }


    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_ns2", r -> r.path("/guoji").
                uri("http://news.baidu.com/guoji")).
                build();
        return routes.build();

    }


}
