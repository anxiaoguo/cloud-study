package cn.axg.study.commons.thread;

import java.lang.ref.SoftReference;

public class SoftRefrenceTest {


    public static void main(String[] args) {

        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024*1024*10]);

        System.out.println(softReference.get());

        System.gc();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("====>"+softReference.get());

        byte[] bytes = new byte[1014 * 1024 * 10];

        System.out.println("------>"+softReference.get());


    }


}
