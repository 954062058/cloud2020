package com.ns.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-01-26 16:20
 */
@SpringBootApplication
@EnableDiscoveryClient  //启用发现客户端 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class OrderZKMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain80.class, args);
        System.out.println("启动完成！");
    }
}
