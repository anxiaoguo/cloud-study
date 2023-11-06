/**
* @filename:StockAtDao 2022年8月20日
* @project seata-study-stock  V1.0
* Copyright(c) 2020 安晓国 Co. Ltd.
* All right reserved.
*/
package com.axg.cloud.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.axg.cloud.study.model.StockAt;

/**
* <p>自动生成工具：mybatis-dsc-generator</p>
*
* <p>说明： 库存表数据访问层</p>
* @version V1.0
* @author 安晓国
*
*/
@Mapper
public interface StockAtMapper extends BaseMapper<StockAt> {

    int decrStock();


}
