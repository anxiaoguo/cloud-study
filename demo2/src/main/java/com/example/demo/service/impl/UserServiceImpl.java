package com.axg.springboot.demo.service.impl;

import com.axg.springboot.demo.mapper.UserMapper;
import com.axg.springboot.demo.model.User;
import com.axg.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }
}
