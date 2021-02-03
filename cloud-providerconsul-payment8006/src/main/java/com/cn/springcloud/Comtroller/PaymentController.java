package com.cn.springcloud.Comtroller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

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

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/consul")
    public String paymentConsul() {
        return "springcloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
