package com.ce.userservice.controller;

import com.ce.userservice.domain.CommonResult;
import com.ce.userservice.domain.User;
import com.ce.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author c__e
 * @date 2021/4/15 9:39
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public CommonResult<Object> create(@RequestBody User user) {
        userService.create(user);
        return CommonResult.success();
    }

    @GetMapping("/{id}")
    public CommonResult<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        logger.info("根据id获取用户信息，用户名称为：{}", user.getUsername());
        return new CommonResult<>(user);
    }

    @GetMapping("/getUserByIds")
    public CommonResult<List<User>> getUserByIds(@RequestParam List<Long> ids) {
        List<User> userList = userService.getUserByIds(ids);
        logger.info("根据ids获取用户信息，用户列表为：{}", userList);
        return new CommonResult<>(userList);
    }

    @GetMapping("/getByUsername")
    public CommonResult<User> getByUsername(@RequestParam String username) {
        User user = userService.getByUsername(username);
        return new CommonResult<>(user);
    }

    @PostMapping("/update")
    public CommonResult<Object> update(@RequestBody User user) {
        userService.update(user);
        return CommonResult.success();
    }

    @PostMapping("/delete/{id}")
    public CommonResult<Object> delete(@PathVariable Long id) {
        userService.delete(id);
        return CommonResult.success();
    }
}
