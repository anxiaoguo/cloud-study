/**
* @filename:OrderAt 2022年8月20日
* @project seata-study-order  V1.0
* Copyright(c) 2020 安晓国 Co. Ltd.
* All right reserved.
*/
package cn.axg.study.seata.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* <p>自动生成工具：mybatis-dsc-generator</p>
*
* <p>说明： 订单表实体类</P>
* @version V1.0
* @author 安晓国
*
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderAt extends Model<OrderAt> {

    private static final long serialVersionUID = 1687241458158L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(name = "id" , value = "主键")
    private Long id;

    @ApiModelProperty(name = "productId" , value = "商品")
    private Long productId;

    @ApiModelProperty(name = "count" , value = "数量")
    private Integer count;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
