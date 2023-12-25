package cn.axg.study.commons.thread;

import cn.axg.study.commons.model.User;

import java.lang.ref.WeakReference;

public class WeakRefrenceTest {

    public static void main(String[] args) {

        User user = new User();

        WeakReference<User> weakReference = new WeakReference<>(new User());

        System.out.println(weakReference.get());

        System.gc();


        System.out.println(weakReference.get());





    }


}
