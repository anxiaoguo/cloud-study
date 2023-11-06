/**
* @filename:StockAtServiceImpl 2022年8月20日
* @project seata-study-stock  V1.0
* Copyright(c) 2018 安晓国 Co. Ltd.
* All right reserved.
*/
package com.axg.cloud.study.service.impl;

import com.axg.cloud.study.model.StockAt;
import com.axg.cloud.study.mapper.StockAtMapper;
import com.axg.cloud.study.service.StockAtService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* <p>自动生成工具：mybatis-dsc-generator</p>
*
* <p>说明： 库存表服务实现层</P>
* @version V1.0
* @author 安晓国
*
*/
@Service
public class StockAtServiceImpl  extends ServiceImpl<StockAtMapper, StockAt> implements StockAtService  {

    @Override
    public int decrStock() {
        return this.baseMapper.decrStock();
    }
}