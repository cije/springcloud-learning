package com.ce.seatastorageservice.module;

import lombok.Data;

import java.io.Serializable;

/**
 * @author c__e
 * @date 2021/4/20 15:38
 */
@Data
public class Storage implements Serializable {
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
