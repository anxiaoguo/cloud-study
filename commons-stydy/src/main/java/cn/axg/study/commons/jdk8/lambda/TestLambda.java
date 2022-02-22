package cn.axg.study.commons.jdk8.lambda;

import org.junit.Test;

/**
 * 此类用于学习Lambda表达式语法()->{};
 */
public class TestLambda {

    /**
     * 1.带一个参数时使用Lambda（参数的括号也可以省略不写）
     */
    @Test
    public void test() {

        //匿名内部类
        Phone phone = new Phone() {
            @Override
            public void tele(String phoneNumber) {
                System.out.println("具体业务" + phoneNumber);
            }
        };
        phone.tele("18888888888");

        //一个参数的时候使用Lambda(参数的括号也可以去掉)
        Phone phone1 = (phoneNumber) -> {
            System.out.println("使用Lambda表达式" + phoneNumber);
        };
        phone1.tele("16666666666");
    }

    /**
     * 2.不带参数时使用Lambda
     */
    @Test
    public void test3() {
        Phone3 phone = () -> System.out.println("不带参数时候使用");
        phone.tele();
    }

    /**
     * 3.带多个参数的时候使用lambda表达式
     */
    @Test
    public void test2() {
        Phone2 phone = (p, n) -> System.out.println("p:" + p + "=====" + "n:" + n);
        phone.tele("16666666666", "jack");
    }

//////////////////////////////////////////////////////////////////////////////

    /**
     * 4.代码块中只有一句代码时候大括号也可以省略不写
     */
    @Test
    public void test4() {
        Phone3 phone = () -> System.out.println("代码块中只有一句");
        phone.tele();
    }

    /**
     * 5.代码块中有多句代码时，必须写大括号
     */
    @Test
    public void test5() {
        Phone3 phone = () -> {
            System.out.println("代码块中有多句");
            System.out.println("代码块中有多句");
            System.out.println("代码块中有多句");
        };
        phone.tele();
    }

    /**
     * 6
     * 有返回值的时候Lambda表达式编写
     * 当代码块中只有一句话，则可以省略大括号,并且不用加上return
     * 当代码块中有多句话的时候，则不能省略大括号,并且要加上return
     */
    @Test
    public void test6() {
        Phone4 phone = () -> "hello Lambda";

        Phone4 phone4 = () -> {
            System.out.println("业务~~~~");
            return "业务结束返回";
        };
    }

}
