package cn.axg.study.redis.service.impl;

import cn.axg.study.redis.mapper.UserMapper;
import cn.axg.study.redis.model.User;
import cn.axg.study.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public User findOne(Integer id) {
        return userMapper.findOne(id);
    }
}
