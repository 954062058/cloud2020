package com.ns.springcloud.service.impl;

import com.ns.springcloud.entities.CommonResult;
import com.ns.springcloud.entities.Payment;
import com.ns.springcloud.repository.PaymentRepository;
import com.ns.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-01-27 10:34
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    @Transactional
    public CommonResult create(Payment payment) {
        Payment save = paymentRepository.save(payment);
        if (save == null) {
            return CommonResult.error();
        } else return CommonResult.success();
    }

    @Override
    @Transactional
    public CommonResult getPaymentById(Long id) {
        Optional<Payment> byId = paymentRepository.findById(id);
        if (byId == null) {
            return CommonResult.error();
        } else return CommonResult.success();
    }
}
