package cn.axg.study.shiro.config;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class Md5Utils {

    /**
     * Shiro MD5
     * 202cb962ac59075b964b07152d234b70
     * f099f9464b2c74489ca422c0178f45f9
     * 1386355dd9724b4e09cc025ab975f625
     */
    @Test
    public void test() {
        //创建一个MD5算法，需要使用构造函数传参的形式
        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println(md5Hash.toHex());

        //使用Md5+salt处理
        Md5Hash md5Hash1 = new Md5Hash("123", "^*esci8709~");
        System.out.println(md5Hash1);
        //使用Md5+salt+hash处理 散列2048次
        Md5Hash md5Hash2 = new Md5Hash("123", "^*esci8709~", 2048);
        System.out.println(md5Hash2);


    }

}
