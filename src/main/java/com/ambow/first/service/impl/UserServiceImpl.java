package com.ambow.first.service.impl;

import com.ambow.first.dao.UserMapper;
import com.ambow.first.entity.User;
import com.ambow.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void save(User user) {
        userMapper.insert(user);
    }
}
