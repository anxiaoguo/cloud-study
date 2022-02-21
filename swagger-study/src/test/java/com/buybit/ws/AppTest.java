package com.buybit.ws;

import com.axg.boot.AppStart;
import com.axg.boot.model.Book;
import com.axg.boot.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = AppStart.class)
@RunWith(SpringRunner.class)
public class AppTest {

    @Autowired
    private BookService bookService;

    @Test
    public void test(){
//        Book byId = bookService.getById(1017);
//        System.out.println("============>"+byId);

//        String fileUrl = "D:\\project\\cloud-study\\swagger-study\\src\\main\\java\\";
        //把路径中的java替换成resources
//        String s = fileUrl.replaceFirst("java", "resources");
//        System.out.println(s);

        Book byId = bookService.getById(1001);
        System.out.println(byId);

    }

}
