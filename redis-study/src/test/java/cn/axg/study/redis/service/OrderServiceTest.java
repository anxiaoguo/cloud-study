package cn.axg.study.redis.service;

import cn.axg.study.redis.RedisApplication;
import cn.axg.study.redis.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = RedisApplication.class)
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testFindAll(){
        List<Order> all = orderService.findAll();
        all.forEach(order-> System.out.println(order));
        System.out.println("================================");
        List<Order> all2 = orderService.findAll();
        all2.forEach(order-> System.out.println(order));
    }

    @Test
    public void testDelete(){
        orderService.deleteById(2);
    }
}
