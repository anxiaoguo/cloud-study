package cn.axg.study.commons.model;

import java.sql.SQLOutput;

public class XIAOMEI extends Man{


    public XIAOMEI(){
        super();
        System.out.println("我是构造方法~~");
    }

    public XIAOMEI(String name,Integer age){
        super("sss");
    }

    public XIAOMEI(String name){
        this("heh",18);
        System.out.println("什么呀");
    }


    @Override
    public String choose(Object var1) {
        return null;
    }
}
