/**
 * @filename:StockAt 2022年8月20日
 * @project seata-study-stock  V1.0
 * Copyright(c) 2020 安晓国 Co. Ltd.
 * All right reserved.
 */
package com.axg.cloud.study.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 *
 * <p>说明： 库存表实体类</P>
 * @version V1.0
 * @author 安晓国
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StockAt extends Model<StockAt> {

    private static final long serialVersionUID = 1687243107262L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(name = "id", value = "主键")
    private Long id;

    @ApiModelProperty(name = "productId", value = "商品id")
    private Long productId;

    @ApiModelProperty(name = "count", value = "库存数量")
    private Integer count;

    @ApiModelProperty(name = "money", value = "单价")
    private BigDecimal money;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
