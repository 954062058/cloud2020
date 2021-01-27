package com.ns.springcloud.service;

import com.ns.springcloud.entities.CommonResult;
import com.ns.springcloud.entities.Payment;
import org.springframework.data.repository.query.Param;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-01-27 10:31
 */
public interface PaymentService {
    public CommonResult create(Payment payment);
    public CommonResult getPaymentById(@Param("id") Long id);
}
