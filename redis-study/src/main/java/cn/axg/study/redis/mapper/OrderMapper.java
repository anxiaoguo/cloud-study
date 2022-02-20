package cn.axg.study.redis.mapper;

import cn.axg.study.redis.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface OrderMapper {

    List<Order> findAll();

    int deleteById(Integer id);

}
