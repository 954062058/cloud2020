package com.ns.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {
    public static void main(String[] args) {

        //TODO 这个springCloud使用SR1会报错
        SpringApplication.run(GateWayMain9527.class, args);
    }
}
 
 
