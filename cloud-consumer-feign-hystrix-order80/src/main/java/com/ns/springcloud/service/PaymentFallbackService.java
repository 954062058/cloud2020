package com.ns.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-03-01 14:28
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back--paymentInfo_OK , (꒦_꒦) ";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back--paymentInfo_TimeOut , (꒦_꒦) ";
    }
}
