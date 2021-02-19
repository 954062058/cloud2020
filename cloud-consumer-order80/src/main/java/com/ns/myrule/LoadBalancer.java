package com.ns.myrule;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-02-18 14:58
 * 不用  试试手
 */
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
