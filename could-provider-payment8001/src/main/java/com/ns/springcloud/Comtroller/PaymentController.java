package com.ns.springcloud.Comtroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ns.springcloud.entities.CommonResult;
import com.ns.springcloud.entities.Payment;
import com.ns.springcloud.mapper.PaymentMapper;
import com.ns.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-01-27 10:32
 */
@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("create")  //post是写
    public CommonResult create(@RequestBody Payment payment) {
        Payment commonResult = paymentService.create(payment);
        log.info("serverPort:" + serverPort + ";插入结果为" + commonResult);
        if (commonResult == null) {
            return CommonResult.error();
        } else return CommonResult.success("serverPort:" + serverPort, commonResult);
    }

    @GetMapping("/find/{id}")
    public CommonResult find(@PathVariable(value = "id") String id) {
        long i = Integer.parseInt(id);
        Payment commonResult = paymentService.getPaymentById(i);
        log.info("serverPort:" + serverPort + ";查询结果为" + commonResult);
        if (commonResult == null) {
            return CommonResult.error();
        } else return CommonResult.success("serverPort:" + serverPort, commonResult);
    }

    @GetMapping("discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("打印-->********service:" + service + "*********");
        }
        //根据微服务名称获得
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("打印-->nstance:" + instance + "\t" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);//直接休息3s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
