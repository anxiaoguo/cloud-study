package com.axg.springboot.demo.mapper;

import com.axg.springboot.demo.model.User;

public interface UserMapper {

    User selectUserById(Integer id);
}
