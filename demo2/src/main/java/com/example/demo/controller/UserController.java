package com.axg.springboot.demo.controller;

import com.axg.springboot.demo.model.User;
import com.axg.springboot.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;


    @GetMapping("/getUserById")
    public User getUserById(String id) {
        logger.info("请求方法{},获取到id={}", "getUserById", id);
        User user = userService.selectUserById(Integer.parseInt(id));
        logger.info("获取用户信息{}",user);
        return user;
    }

}
