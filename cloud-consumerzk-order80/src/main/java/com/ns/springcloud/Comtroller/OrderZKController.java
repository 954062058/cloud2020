package com.ns.springcloud.Comtroller;

import com.ns.springcloud.entities.CommonResult;
import com.ns.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-01-27 10:32
 */
@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderZKController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment) { //创造一个create(Payment payment)   读get 写post
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);  //写操作
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/find/" + id, CommonResult.class);
    }
}
