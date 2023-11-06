package com.axg.cloud.study.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@DependsOn("orderService")
@Service
public class OrderService {

    @Autowired
    private TradeService tradeService;

    public void testCreateOrder() {
        // omit business logic ...
    }

}
