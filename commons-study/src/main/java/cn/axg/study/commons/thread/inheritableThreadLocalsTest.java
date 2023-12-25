package cn.axg.study.commons.thread;

public class inheritableThreadLocalsTest {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        threadLocal.set("我是主线程ThreadLocal");
        inheritableThreadLocal.set("我是主线程InheritableThreadLocal");


        new Thread(()->{

            System.out.println("threadLocal---->"+threadLocal.get());

            //在子线程中获取父线程中的值
            System.out.println("inheritableThreadLocal---->"+inheritableThreadLocal.get());

            inheritableThreadLocal.set("呵呵呵哒");
            System.out.println("inheritableThreadLocal---->"+inheritableThreadLocal.get());


        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("主线程inheritableThreadLocal---->"+inheritableThreadLocal.get());


    }



}
