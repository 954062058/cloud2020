package com.ns.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

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

    /**
     *此配置是为了服务监控而配置，与服务容错本身无关，springcLoud升级后的坑
     *ServletRegistrationBean因为springboot的默认路径不是" /hystrix.stream " ,
     *只要在自已的项目里配置上下面的servLet就可以了
     */

    //TODO 豪猪哥生效配置

    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }



}
 
 
