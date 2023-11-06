/**
 * @filename:OrderAtController 2022年8月20日
 * @project seata-study-order  V1.0
 * Copyright(c) 2020 安晓国 Co. Ltd.
 * All right reserved.
 */
package cn.axg.study.seata.controller;

import cn.axg.study.seata.feign.DecrStockFeign;
import cn.axg.study.seata.model.OrderAt;
import cn.axg.study.seata.service.OrderAtService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 *
 * <p>说明： 订单表API接口层</P>
 *
 * @author 安晓国
 * @version V1.0
 */
@Api(tags = "订单表", value = "订单表")
@RestController
@RequestMapping("/orderAt")
public class OrderAtController {


    @Resource
    private OrderAtService orderAtService;

    @Resource
    private DecrStockFeign stockFeign;

    @GetMapping("/getOne")
    public List<OrderAt> getOne() {
        LambdaQueryWrapper<OrderAt> queryWrapper = new LambdaQueryWrapper<>();
        List<OrderAt> list = orderAtService.list(queryWrapper);
        return list;
    }


    /**
     * 下订单
     *
     * @return
     */
    @GetMapping("/addOrder")
    public String addOrder() {
        if (orderAtService.testOrder() > 0) {
            return "下单成功！！！";
        }
        return "下单失败";
    }

    /**
     * 测试feign是否走得通
     *
     * @return
     */
    @GetMapping("/testFeign")
    public String testFeign() {
        String decr = stockFeign.decr();
        return decr;
    }

}