package cn.axg.study.redis.service;

import cn.axg.study.redis.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    int delete(Integer id);

    User findOne(Integer id);

}
