package cn.axg.study.commons.thread;

import cn.axg.study.commons.model.User;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {

    public static void main(String[] args) {

        ReferenceQueue<User> referenceQueue = new ReferenceQueue();

        PhantomReference<User> phantomReference = new PhantomReference<>(new User(),referenceQueue);

        System.out.println(phantomReference.get());


    }


}
