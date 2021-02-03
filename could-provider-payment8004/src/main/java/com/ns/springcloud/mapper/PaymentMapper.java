package com.ns.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ns.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-01-27 9:58
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
