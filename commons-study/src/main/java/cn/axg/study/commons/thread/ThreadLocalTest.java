package cn.axg.study.commons.thread;

public class ThreadLocalTest {


    static ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {

        long id = Thread.currentThread().getId();
        System.out.println(id);
        threadLocal.set("你好啊");

        new Thread(()->{
            threadLocal.set("hello");
            //这种情况下不能获取
            System.out.println("=====>"+threadLocal.get());
            //线程本地变量用好之后一定要记得清掉
            threadLocal.remove();
            System.out.println("=====>"+threadLocal.get());
            long id2 = Thread.currentThread().getId();
            System.out.println(id2);
        }).start();

        System.out.println("---------->"+threadLocal.get());
    }

}
