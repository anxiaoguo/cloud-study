/**
 * @filename:OrderAtService 2022年8月20日
 * @project seata-study-order  V1.0
 * Copyright(c) 2020 安晓国 Co. Ltd.
 * All right reserved.
 */
package cn.axg.study.seata.service;

import cn.axg.study.seata.model.OrderAt;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 *
 * <p>说明： 订单表服务层</P>
 * @version V1.0
 * @author 安晓国
 *
 */
public interface OrderAtService extends IService<OrderAt> {

    int addOrder(OrderAt orderAt);

    int testOrder();


}