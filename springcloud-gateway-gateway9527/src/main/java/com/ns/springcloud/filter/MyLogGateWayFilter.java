package com.ns.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter,Ordered {
    /**
     * 这样做访问上需要加上username
     *
     * curl http://localhost:9527/payment/lb?username=z3 --cookie "username=ns" -H"X-Request-Id:123"
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("*********come in MyLogGateWayFilter: "+new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if(StringUtils.isEmpty(username)){
            log.info("*****用户名为Null 非法用户,(┬＿┬)");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//给人家一个回应 不被接受的http状态码
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange); //去下一个过滤链进行验证
    }

    @Override
    /**
     * 加载的顺序 数字越小 优先级越高  对应上面 GlobalFilter,Ordered
     */
    public int getOrder() {
        return 0;
    }
}
 
 
