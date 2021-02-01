package com.ns.springcloud.Comtroller;

import com.ns.springcloud.entities.CommonResult;
import com.ns.springcloud.entities.Payment;
import com.ns.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("create")  //post是写
    public CommonResult create(@RequestBody Payment payment){
        Payment commonResult = paymentService.create(payment);
        log.info("serverPort:"+serverPort+";插入结果为"+commonResult);
        if (commonResult == null) {
            return CommonResult.error();
        } else return CommonResult.success("serverPort:"+serverPort,commonResult);
    }

    @GetMapping("/find/{id}")
    public CommonResult find(@PathVariable(value = "id") String id){
        long i = Integer.parseInt(id);
        Payment commonResult = paymentService.getPaymentById(i);
        log.info("serverPort:"+serverPort+";查询结果为"+commonResult);
        if (commonResult == null) {
            return CommonResult.error();
        } else return CommonResult.success("serverPort:"+serverPort,commonResult);
    }
}