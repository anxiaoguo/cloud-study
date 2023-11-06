package cn.axg.study.commons.model;

public abstract class Man implements Person{


    private String str;

    public String age;

    public Man() {
        System.out.println("构造方法");
    }

    public Man(String str) {
        this.str = str;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public void setLoadBalancer(String str) {
        this.str = str;
    }

    @Override
    public String getLoadBalancer() {
        return this.str;
    }
}
