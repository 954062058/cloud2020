package com.ns.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 解决If you want an embedded database (H2, HSQL or Derby), please put it on the classpath.问题
   (exclude= {DataSourceAutoConfiguration.class})
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  //服务降级主启动类激活注解
@Slf4j
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
        log.info("启动成功");
    }
}
 
 
