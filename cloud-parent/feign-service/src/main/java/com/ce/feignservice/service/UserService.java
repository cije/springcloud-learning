package com.ce.feignservice.service;

import com.ce.feignservice.domain.CommonResult;
import com.ce.feignservice.domain.User;
import com.ce.feignservice.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author c__e
 * @date 2021/4/15 15:21
 */
@FeignClient(value = "user-service", fallback = UserFallbackService.class)
public interface UserService {

    @PostMapping("/user/create")
    CommonResult<Object> create(@RequestBody User user);

    @GetMapping("/user/{id}")
    CommonResult<User> getUser(@PathVariable(value = "id") Long id);

    @GetMapping("/user/getUserByIds")
    CommonResult<List<User>> getUserByIds(@RequestParam("ids") List<Long> ids);

    @GetMapping("/user/getByUsername")
    CommonResult<User> getByUsername(@RequestParam("username") String username);

    @PostMapping("/user/update")
    CommonResult<Object> update(@RequestBody User user);

    @PostMapping("/user/delete/{id}")
    CommonResult<Object> delete(@PathVariable(value = "id") Long id);
}