package com.ce.seataorderservice.service;

import com.ce.seataorderservice.module.Order;

/**
 * @author c__e
 * @date 2021/4/20 15:39
 */
public interface OrderService{
    /**
     * 创建订单
     */
    void create(Order order);
}
