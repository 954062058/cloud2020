package com.ns.springcloud.service;
import com.ns.springcloud.entities.Payment;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-01-27 10:31
 */

public interface PaymentService {
    Payment create(Payment payment);

    Payment getPaymentById(@Param("id") Integer id);
}
