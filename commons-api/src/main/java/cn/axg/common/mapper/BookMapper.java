/**
 * @filename:BookDao 2019年6月12日
 * @project commons-api  V1.0
 * Copyright(c) 2020 anxiaoguo Co. Ltd. 
 * All right reserved. 
 */
package cn.axg.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import cn.axg.common.model.Book;

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
