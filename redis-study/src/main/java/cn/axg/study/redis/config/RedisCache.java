package cn.axg.study.redis.config;

import cn.axg.study.redis.utils.RedisUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.DigestUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Mybatis自定义缓存 Redis >>>>mybatis解决了缓存穿透
 */
public class RedisCache implements Cache {

    private final String id;

    public RedisCache(String id) {
        this.id = id;
    }

    //此id值为mapper的namespace全限定名
    @Override
    public String getId() {
        System.out.println("id=============>"+this.id);
        return this.id;
    }

    //把数据放入缓存中
    @Override
    public void putObject(Object o, Object o1) {

        System.out.println("===============放入缓存=====================");
        RedisTemplate redisTemplate = (RedisTemplate) RedisUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForHash().put(this.id,getMD5tokey(o.toString()),o1);
        //（缓存优化）针对不同的业务模块设置缓存不同的失效的时间，可以在一定程度上防止缓存雪崩
        //在一段时间里查询此时次数比较多的地方比较适合加失效时间
        if (this.id.equals("cn.axg.study.redis.mapper.OrderMapper")){
            redisTemplate.expire(this.id,1, TimeUnit.DAYS);
        }
    }

    //从缓存中获取数据
    @Override
    public Object getObject(Object o) {
        System.out.println("=====================读取缓存======================");
        RedisTemplate redisTemplate = (RedisTemplate) RedisUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate.opsForHash().get(this.id,getMD5tokey(o.toString()));
    }

    //删除缓存，该方法没有用到
    @Override
    public Object removeObject(Object o) {
        System.out.println("=================删除缓存=====================");
        return null;
    }

    //清空缓存
    @Override
    public void clear() {
        RedisTemplate redisTemplate = (RedisTemplate) RedisUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.delete(this.id);
        System.out.println("=================清空缓存=================");
    }

    //读写锁 ReadWriteLock synchronized线程并发时的安全
    @Override
    public ReadWriteLock getReadWriteLock() {
        return new ReentrantReadWriteLock();
    }

    @Override
    public int getSize() {
        System.out.println("=================获取缓存数量===================");
        RedisTemplate redisTemplate = (RedisTemplate) RedisUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate.opsForHash().size(this.id).intValue();
    }

    /**
     * 对key进行md5加密 （缓存优化-减小key存储的长度）
     * @param key
     * @return
     */
    private static String getMD5tokey(String key){
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
