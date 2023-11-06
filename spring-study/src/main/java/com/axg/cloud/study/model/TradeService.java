package com.axg.cloud.study.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@DependsOn("tradeService")
@Service
public class TradeService {


    @Resource
    private UserService userService;

    public void testCreateTrade() {
        // omit business logic ...
    }
}
