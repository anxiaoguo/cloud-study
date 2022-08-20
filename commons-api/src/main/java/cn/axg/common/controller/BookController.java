/**
 * @filename:BookController 2019年6月12日
 * @project commons-api  V1.0
 * Copyright(c) 2020 anxiaoguo Co. Ltd.
 * All right reserved.
 */
package cn.axg.common.controller;

import cn.axg.common.api.CommonPage;
import cn.axg.common.api.CommonResult;
import cn.axg.common.model.Book;
import cn.axg.common.service.BookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 *
 * <p>说明： 书籍表API接口层</P>
 *
 * @version: V1.0
 * @author: anxiaoguo
 * @time 2019年6月12日
 */
@Api(description = "书籍表", value = "书籍表")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * Mybatis方式的分页
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public CommonResult<CommonPage<Book>> list(@RequestParam(defaultValue = "1") Integer currentPage,
                                               @RequestParam(defaultValue = "3") Integer pageSize) {

        PageHelper.startPage(currentPage, pageSize);
        //获取图书列表
        List<Book> list = bookService.list();
        return CommonResult.success(CommonPage.restPage(list));
    }


    /**
     * Hutools分页方式
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/list2")
    public CommonResult<CommonPage<Book>> list2(@RequestParam(defaultValue = "1") Integer currentPage,
                                                @RequestParam(defaultValue = "3") Integer pageSize) {

        List<Book> list = bookService.list();
        return CommonResult.success(CommonPage.restPage(currentPage, pageSize, list));
    }

    @GetMapping("/test")
    public void test() {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Book::getName,"编译原理");
        Book one = bookService.getOne(wrapper);
        System.out.println(one);
    }

}