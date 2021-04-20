package com.ce.seataorderservice.mapper;

import com.ce.seataorderservice.module.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author c__e
 * @date 2021/4/20 15:42
 */
public interface OrderMapper {
    void updateStatus(@Param("userId") Long userId, @Param("status") int status);

    void insert(Order order);
}
