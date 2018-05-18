package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectUserInfo(String userId) {
        return  userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int save(User user) {
        return  userMapper.insertSelective(user);
    }
}