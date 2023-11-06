/**
 * @filename:StockAtController 2022年8月20日
 * @project seata-study-stock  V1.0
 * Copyright(c) 2020 安晓国 Co. Ltd.
 * All right reserved.
 */
package com.axg.cloud.study.controller;

import com.axg.cloud.study.service.StockAtService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 *
 * <p>说明： 库存表API接口层</P>
 *
 * @author 安晓国
 * @version V1.0
 */
@Api(tags = "库存表", value = "库存表")
@RestController
@RequestMapping("/stockAt")
public class StockAtController {


    @Resource
    private StockAtService stockAtService;

    /**
     * 减库存
     *
     * @return
     */
    @GetMapping("/decr")
    public String decr() {
        if (stockAtService.decrStock() > 0) {
            return "成功下单";
        }
        return "下单失败";
    }

}