package com.ce.seataaccountservice.mapper;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author c__e
 * @date 2021/4/20 15:36
 */
public interface AccountMapper {

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
