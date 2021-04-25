package com.ce.microknife4jorder.service;

import com.ce.microknife4jorder.domain.Order;

/**
 * @author c__e
 * @date 2021/4/25 14:37
 */
public interface OrderService {
    void create(Order order);

    Order getOrder(Long id);

    void update(Order order);

    void delete(Long id);
}
