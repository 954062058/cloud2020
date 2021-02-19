package com.ns.springcloud.controller;

import com.ns.springcloud.entities.CommonResult;
import com.ns.springcloud.entities.Payment;
import com.ns.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-02-19 15:43
 */
@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/find/{id}")
    public CommonResult find(@PathVariable(value = "id") String id){
        long i = Integer.parseInt(id);
        CommonResult commonResult = paymentFeignService.getPaymentById(i);

        if (commonResult == null) {
            return CommonResult.error();
        } else return CommonResult.success(commonResult);
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openFeign底层==>ribbon, 客户端一般默认等待1s
        return paymentFeignService.paymentFeignTimeout();
    }
}
