package com.ns.springcloud.service.impl;

import com.ns.springcloud.entities.Payment;
import com.ns.springcloud.mapper.PaymentMapper;
import com.ns.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-01-27 10:34
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    @Transactional
    public Payment create(Payment payment) {
        int insert = paymentMapper.insert(payment);
        return     paymentMapper.selectById(payment.getId());
    }

    @Override
    @Transactional
    public Payment getPaymentById(Long id) {
        Payment payment = paymentMapper.selectById(id);
        return payment;
    }
}
