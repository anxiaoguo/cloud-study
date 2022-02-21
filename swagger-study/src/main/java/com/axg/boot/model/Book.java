/**
 * @filename:Book 2019年6月12日
 * @project naco-study  V1.0
 * Copyright(c) 2020 anxiaoguo Co. Ltd. 
 * All right reserved. 
 */
package com.axg.boot.model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 书籍表实体类</P>
 * @version: V1.0
 * @author: anxiaoguo
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Book extends Model<Book> {

	private static final long serialVersionUID = 1645426403724L;
	
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(name = "id" , value = "图书ID")
	private Integer id;
    
	@ApiModelProperty(name = "name" , value = "图书名称")
	private String name;
    
	@ApiModelProperty(name = "number" , value = "馆藏数量")
	private Integer number;
    

	@Override
    protected Serializable pkVal() {
        return this.id;
    }
}
