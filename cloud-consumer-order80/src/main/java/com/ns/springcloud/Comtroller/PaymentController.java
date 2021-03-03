package com.ns.springcloud.Comtroller;

import com.ns.springcloud.entities.CommonResult;
import com.ns.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
public class PaymentController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){ //创造一个create(Payment payment)   读get 写post
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);  //写操作
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/find/"+id,CommonResult.class);
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){ //   读get 写post
        return restTemplate.getForObject(PAYMENT_URL+"/payment/discovery",Object.class);  //写操作
    }

    @GetMapping("/payment/lb")
    public String  lb(){ //  读get 写post
        return restTemplate.getForObject(PAYMENT_URL+"/payment/lb",String.class);  //写操作
    }




    @GetMapping("/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/find/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }
}
