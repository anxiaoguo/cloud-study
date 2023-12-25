package cn.axg.study.commons.thread;

public class ThreadTest {


   volatile boolean flag = true;


    public void m(){

        System.out.println("start ~");
        while (flag){

        }
        System.out.println("end ~");
    }

    public static void main(String[] args) {

        ThreadTest t = new ThreadTest();

        new Thread(t::m,"thread1").start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t.flag = false;
        System.out.println("执行玩了。。。。");

    }


}
