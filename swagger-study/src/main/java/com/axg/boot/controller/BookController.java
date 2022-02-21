/**
 * @filename:BookController 2019年6月12日
 * @project naco-study  V1.0
 * Copyright(c) 2020 anxiaoguo Co. Ltd. 
 * All right reserved. 
 */
package com.axg.boot.controller;

import com.axg.boot.model.Book;
import com.axg.boot.service.BookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 书籍表API接口层</P>
 * @version: V1.0
 * @author: anxiaoguo
 * @time    2019年6月12日
 *
 */
@Api(tags = "图书接口", value = "图书表接口")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation("根据id获取图书信息")
//    @ApiImplicitParams({
//              @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "path")
//            @ApiImplicitParam(name = "name", value = "名字", required = true, paramType = "query")
//    })
    @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "path")
    @GetMapping("/{id}")
    public Book getOne(@PathVariable("id") String id){
        return bookService.getById(1001);
    }

}