package cn.axg.study.redis.service;

import cn.axg.study.redis.RedisApplication;
import cn.axg.study.redis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@Slf4j
@SpringBootTest(classes = RedisApplication.class)
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testfindAll(){
        List<User> all = userService.findAll();
//        all.forEach(user-> System.out.println(user));

        System.out.println(all);
        log.error("======================================");
        List<User> all1 = userService.findAll();
        all.forEach(user-> System.out.println(user));

    }

    @Test
    public void testDelete(){
        int delete = userService.delete(1);

    }

    @Test
    public void findOne(){
        User one = userService.findOne(100);
    }


}
