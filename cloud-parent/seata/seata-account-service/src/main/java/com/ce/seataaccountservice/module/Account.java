package com.ce.seataaccountservice.module;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author c__e
 * @date 2021/4/20 15:31
 */
@Data
public class Account implements Serializable {

    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;

}
