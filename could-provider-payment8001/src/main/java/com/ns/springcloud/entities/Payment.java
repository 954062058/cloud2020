package com.ns.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-01-27 9:28
 */
@Data
@AllArgsConstructor //全参数
@NoArgsConstructor //空参数
public class Payment implements Serializable /*序列化*/ {
    private Long id; //id
    private String serial; //流水号
}
