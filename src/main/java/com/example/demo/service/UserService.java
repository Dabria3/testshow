package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User selectUserInfo(String userId);

    int save(User user);
}