package cn.axg.study.redis.springboot;

import cn.axg.study.redis.model.Book;
import cn.axg.study.redis.model.Order;
import cn.axg.study.redis.model.User;

import java.util.ArrayList;
import java.util.List;

public class Test {

    @org.junit.Test
    public void test(){
        System.out.println(5%3);

        User user = new User();

        Book book = new Book();

        Order order = new Order();
        order.setId(1);
        order.setTotalPrice("12");
        order.setUserId(2);

        Order order2 = new Order();
        order2.setId(1);
        order2.setTotalPrice("12");
        order2.setUserId(2);
        List<Order> list = new ArrayList<>();
        list.add(order);
        list.add(order2);
        System.out.println(list);
    }
}
