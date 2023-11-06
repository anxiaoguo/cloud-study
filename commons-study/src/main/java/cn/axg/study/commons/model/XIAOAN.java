package cn.axg.study.commons.model;

public class XIAOAN extends Man{


    public XIAOAN() {
        super("我不知道你在干什么");
    }

    public XIAOAN(String str){
        super();
    }




    @Override
    public String toString() {
        return "XIAOAN{" +
                "age='" + age + '\'' +
                '}';
    }

    public XIAOAN(String str, String name){
        this(str);
    }


    public void xx(){
        System.out.println(super.age);
    }


    @Override
    public String choose(Object var1) {
        return "hello";
    }
}
