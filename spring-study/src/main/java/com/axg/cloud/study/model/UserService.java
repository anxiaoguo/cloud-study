package com.axg.cloud.study.model;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@DependsOn("userService")
@Service
public class UserService {


    @Resource
    private OrderService orderService;


}
