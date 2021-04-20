package com.ce.seatastorageservice.service;

/**
 * @author c__e
 * @date 2021/4/20 15:39
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
