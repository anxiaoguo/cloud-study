package cn.axg.study.commons.jdk8.basic;

import cn.axg.study.commons.model.*;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Properties;

@Data
public class TestData {



    private Person person;


    public TestData() {


        //获取配置 你的配置是什么 那我就走哪里的方法
        this.person = new XIAOAN();

    }

    @Test
    public void test(){

        XIAOMEI xiaomei = new XIAOMEI("cscs");


        System.out.println(xiaomei);

//        Integer i = 40;
//
//        Integer x = new Integer(40);
//
//        Integer y = 40;
//
//        System.out.println(i.equals(x));


        String xx = this.person.choose("好好好");

        System.out.println(xx);





        System.out.println(person.getLoadBalancer());

    }


}
