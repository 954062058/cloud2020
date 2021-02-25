package com.ns.springcloud.controller;

import com.ns.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}") //端口号
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id)+" ===端口号为：-->"+serverPort;
        log.info("*******result:"+result);
        return result;
    }
    @GetMapping("/hystrix/timeout/{id}")  //get用着玩意  @PathVariable("id")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_TimeOut(id)+" ===端口号为：-->"+serverPort;
        log.info("*******result:"+result);
        return result;
    }
}
 
 
