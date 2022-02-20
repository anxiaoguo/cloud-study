package cn.axg.study.redis.service;

import cn.axg.study.redis.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    int deleteById(Integer id);
}
