package com.ce.seataorderservice.module;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author c__e
 * @date 2021/4/20 15:38
 */
@Data
public class Order implements Serializable {
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**
     * 订单状态：0：创建中；1：已完结
     */
    private Integer status;
}
