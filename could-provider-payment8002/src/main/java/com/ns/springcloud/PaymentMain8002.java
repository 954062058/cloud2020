package com.ns.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-01-26 16:20
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
        System.out.println("启动完成！");
    }
}
