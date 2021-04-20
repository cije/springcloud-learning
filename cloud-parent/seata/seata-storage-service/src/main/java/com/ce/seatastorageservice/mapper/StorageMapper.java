package com.ce.seatastorageservice.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author c__e
 * @date 2021/4/20 15:42
 */
public interface StorageMapper {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
