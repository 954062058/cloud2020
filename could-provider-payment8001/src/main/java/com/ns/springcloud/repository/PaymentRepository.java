package com.ns.springcloud.repository;

import com.ns.springcloud.entities.Payment;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-01-27 9:58
 */
@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long>, JpaSpecificationExecutor<Payment> {
//    public int create(Payment payment);
//    public Payment getPaymentById(@Param("id") Long id);
}
