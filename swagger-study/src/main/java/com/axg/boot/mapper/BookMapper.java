/**
 * @filename:BookDao 2019年6月12日
 * @project naco-study  V1.0
 * Copyright(c) 2020 anxiaoguo Co. Ltd. 
 * All right reserved. 
 */
package com.axg.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.axg.boot.model.Book;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 书籍表数据访问层</p>
 * @version: V1.0
 * @author: anxiaoguo
 * 
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
	
}
