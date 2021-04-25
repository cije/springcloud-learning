package com.ce.microknife4juser.service;

import com.ce.microknife4juser.domain.User;

import java.util.List;

/**
 * @author c__e
 * @date 2021/4/25 14:26
 */
public interface UserService {
    void create(User user);

    User getUser(Long id);

    void update(User user);

    void delete(Long id);

    User getByUsername(String username);

    List<User> getUserByIds(List<Long> ids);
}
