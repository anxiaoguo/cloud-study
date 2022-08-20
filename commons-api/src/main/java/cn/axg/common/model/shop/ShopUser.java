/**
* @filename:ShopUser 2022年8月20日
* @project cloud-study  V1.0
* Copyright(c) 2020 安晓国 Co. Ltd.
* All right reserved.
*/
package cn.axg.common.model.shop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
    import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
        import java.util.Date;

/**
* <p>自动生成工具：mybatis-dsc-generator</p>
*
* <p>说明： 商户信息表实体类</P>
* @version V1.0
* @author 安晓国
*
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ShopUser extends Model<ShopUser> {

    private static final long serialVersionUID = 1660980416235L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(name = "id" , value = "")
    private Long id;

    @ApiModelProperty(name = "username" , value = "用户名")
    private String username;

    @ApiModelProperty(name = "pwd" , value = "密码")
    private String pwd;

    @ApiModelProperty(name = "gender" , value = "性别 1- 男 2-女 3-未知")
    private Integer gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(name = "createTime" , value = "创建时间")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(name = "updateTime" , value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(name = "deleted" , value = "删除状态 0-未删除 1-已删除")
    private Integer deleted;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
