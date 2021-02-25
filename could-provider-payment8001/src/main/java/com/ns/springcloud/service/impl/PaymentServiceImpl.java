package com.ns.springcloud.service.impl;

import com.ns.springcloud.entities.Payment;
import com.ns.springcloud.mapper.PaymentMapper;
import com.ns.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;


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

    public String a(){
        Payment payment = paymentMapper.selectById(5);
        if (Integer.parseInt(payment.getSerial()) > 0){
            payment.setSerial(String.valueOf(Integer.parseInt(payment.getSerial()) - 1));
            paymentMapper.updateById(payment);
            return "成功";
        }
        return "失败";
    }
}
