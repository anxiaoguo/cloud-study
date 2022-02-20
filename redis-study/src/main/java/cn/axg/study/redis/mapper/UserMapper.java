package cn.axg.study.redis.mapper;

import cn.axg.study.redis.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> findAll();

    int delete(Integer id);

    User findOne(Integer id);
}
