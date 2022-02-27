package cn.axg.study.mapper;

import cn.axg.study.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User selectLoginUser(String username, String password);
}
