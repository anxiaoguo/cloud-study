package com.axg.springboot.demo.service;

import com.axg.springboot.demo.model.User;

public interface UserService {

    User selectUserById(Integer id);
}
