/**
 * @filename:BookServiceImpl 2019年6月12日
 * @project commons-api  V1.0
 * Copyright(c) 2018 anxiaoguo Co. Ltd. 
 * All right reserved. 
 */
package cn.axg.common.service.impl;

import cn.axg.common.model.Book;
import cn.axg.common.mapper.BookMapper;
import cn.axg.common.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 书籍表服务实现层</P>
 * @version: V1.0
 * @author: anxiaoguo
 * 
 */
@Service
public class BookServiceImpl  extends ServiceImpl<BookMapper, Book> implements BookService  {
	
}