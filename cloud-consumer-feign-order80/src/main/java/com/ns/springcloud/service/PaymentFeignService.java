package com.ns.springcloud.service;

import com.ns.springcloud.entities.CommonResult;
import com.ns.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-02-19 15:24
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/find/{id}")
    public CommonResult getPaymentById(@PathVariable(value = "id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
