/**
 * @filename:OrderAtServiceImpl 2022年8月20日
 * @project seata-study-order  V1.0
 * Copyright(c) 2018 安晓国 Co. Ltd.
 * All right reserved.
 */
package cn.axg.study.seata.service.impl;

import cn.axg.study.seata.feign.DecrStockFeign;
import cn.axg.study.seata.mapper.OrderAtMapper;
import cn.axg.study.seata.model.OrderAt;
import cn.axg.study.seata.service.OrderAtService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 *
 * <p>说明： 订单表服务实现层</P>
 *
 * @author 安晓国
 * @version V1.0
 */
@Service
public class OrderAtServiceImpl extends ServiceImpl<OrderAtMapper, OrderAt> implements OrderAtService {


    @Resource
    private DecrStockFeign stockFeign;

    @Override
    public int addOrder(OrderAt orderAt) {
        return this.baseMapper.insert(orderAt);
    }

    @GlobalTransactional
    @Override
    public int testOrder() {
        OrderAt orderAt = new OrderAt();
        orderAt.setProductId(1L);
        orderAt.setCount(1);




        //减库存
        stockFeign.decr();

        int j = 1 / 0;
        //下订单
        int i = addOrder(orderAt);
        if (i > 0) {
            return i;
        }
        return -1;
    }
}