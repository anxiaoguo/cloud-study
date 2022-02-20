package cn.axg.study.redis.springboot;

import cn.axg.study.redis.RedisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis redisTemplate 操作key命令
 */
@SpringBootTest(classes = RedisApplication.class)
@RunWith(SpringRunner.class)
public class RedisCommand_key_Test {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        // del [key] 删除指定key
        Boolean user3 = redisTemplate.delete("user3");
        System.out.println(user3);
        // exists [key] 是否存在key 存在返回true 不存在返回false
        Boolean name = redisTemplate.hasKey("name");
        System.out.println(name);
        // expire [key]设置一个存在的key并且指定存活多久，设置成功返回true
        Boolean axg = redisTemplate.expire("name", 1, TimeUnit.MINUTES);
        System.out.println("axg:" + axg);
        // keys * 查看所在数据库的所有key
        Set keys = redisTemplate.keys("*");
        keys.forEach(key -> System.out.println("key=" + key));
        // move [key] [dbid] 把当前库中key=user的数据移到1号数据库中 【默认有16个数据库 编号0-15】
        Boolean user1 = redisTemplate.move("user", 1);
        System.out.println(user1);
        // ttl [key] 返回-1 表示永久存储 返回-2表示不存在key值 返回 >0 的数据就是存活的时间
        Long age = redisTemplate.getExpire("age1");
        System.out.println("age:" + age);
        // randomkey  获取一个随机的key
        Object o = redisTemplate.randomKey();
        System.out.println("随机key：" + o);
        // rename [key] 改key的名字（key必须存在，不存在就会报异常）
        Boolean aBoolean = redisTemplate.renameIfAbsent("age1", "age");
        System.out.println("改名是否成功：" + aBoolean);
        // type [key] 查看key的数据类型
        DataType age1 = redisTemplate.type("age");
        System.out.println("age1:" + age1);
    }
}
