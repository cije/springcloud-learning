package com.ce.feignservice.service.impl;

import com.ce.feignservice.domain.CommonResult;
import com.ce.feignservice.domain.User;
import com.ce.feignservice.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author c__e
 * @date 2021/4/15 15:58
 */
@Component
public class UserFallbackService implements UserService {
    @Override
    public CommonResult<Object> create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<List<User>> getUserByIds(List<Long> ids) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(CollectionUtils.arrayToList(defaultUser));
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<Object> update(User user) {
        return CommonResult.success();
    }

    @Override
    public CommonResult<Object> delete(Long id) {
        return CommonResult.success();
    }
}
