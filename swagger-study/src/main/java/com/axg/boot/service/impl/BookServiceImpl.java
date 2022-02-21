/**
 * @filename:BookServiceImpl 2019年6月12日
 * @project naco-study  V1.0
 * Copyright(c) 2018 anxiaoguo Co. Ltd. 
 * All right reserved. 
 */
package com.axg.boot.service.impl;

import com.axg.boot.model.Book;
import com.axg.boot.mapper.BookMapper;
import com.axg.boot.service.BookService;
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
@Service("bookServiceImpl")
public class BookServiceImpl  extends ServiceImpl<BookMapper, Book> implements BookService  {
	
}