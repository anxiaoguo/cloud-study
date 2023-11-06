/**
* @filename:StockAtService 2022年8月20日
* @project seata-study-stock  V1.0
* Copyright(c) 2020 安晓国 Co. Ltd.
* All right reserved.
*/
package com.axg.cloud.study.service;

import com.axg.cloud.study.model.StockAt;
import com.baomidou.mybatisplus.extension.service.IService;
/**
* <p>自动生成工具：mybatis-dsc-generator</p>
*
* <p>说明： 库存表服务层</P>
* @version V1.0
* @author 安晓国
*
*/
public interface StockAtService extends IService<StockAt> {

    int decrStock();

}