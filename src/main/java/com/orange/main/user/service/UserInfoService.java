package com.orange.main.user.service;

import java.util.List;

import com.orange.main.user.bo.UserInfo;

public interface UserInfoService {
    UserInfo createUser(UserInfo userInfo);

    UserInfo getUserById(Long userId);

    Iterable<UserInfo> getAllUsers();

    UserInfo updateUser(UserInfo userInfo);

    void deleteUser(Long userId);
}
