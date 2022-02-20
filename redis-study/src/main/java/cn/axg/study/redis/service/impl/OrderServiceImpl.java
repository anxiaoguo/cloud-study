package cn.axg.study.redis.service.impl;

import cn.axg.study.redis.mapper.OrderMapper;
import cn.axg.study.redis.model.Order;
import cn.axg.study.redis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public int deleteById(Integer id) {
        return orderMapper.deleteById(id);
    }
}
