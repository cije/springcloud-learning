package com.ce.seataaccountservice.service;

import java.math.BigDecimal;

/**
 * @author c__e
 * @date 2021/4/20 15:39
 */
public interface AccountService {
    /**
     * 扣减账户余额
     */
    void decrease(Long userId, BigDecimal money);
}
