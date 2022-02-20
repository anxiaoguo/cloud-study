package cn.axg.study.redis.springboot;

import cn.axg.study.redis.RedisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.applet.Applet;
import java.util.*;

@SpringBootTest(classes = RedisApplication.class)
@RunWith(SpringRunner.class)
public class RedisCommand_string_Test {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        // set [key] 往设置的数据库中添加一个key
        redisTemplate.opsForValue().set("bir",new Date());
        // get [key] 获取一个key所对应的value
        Object bir = redisTemplate.opsForValue().get("bir");
        System.out.println(bir);

        // mset [key..] 一次性设置多个值
        Map<Object,Object> map = new HashMap();
        map.put("水果","香蕉");
        map.put("汽车","玛莎拉蒂");
        map.put("时间",new Date());
        redisTemplate.opsForValue().multiSet(map);

        //mget [key..] 一次性获取多个value
        List<Object> list = new ArrayList<>();
        list.add("水果");
        list.add("汽车");
        List list1 = redisTemplate.opsForValue().multiGet(list);
        list1.forEach(o -> System.out.println("value:"+o));


    }

}
