package com.ce.seatastorageservice.service.impl;

import com.ce.seatastorageservice.mapper.StorageMapper;
import com.ce.seatastorageservice.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author c__e
 * @date 2021/4/20 15:40
 */
@Service
public class StorageServiceImpl implements StorageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    private StorageMapper storageMapper;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId, count);
        LOGGER.info("------->storage-service中扣减库存结束");
    }
}
