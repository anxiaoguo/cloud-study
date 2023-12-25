package cn.axg.study.commons.collection;

import cn.axg.study.commons.model.XIAOAN;
import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {


    @Test
    public void test(){

        Set<Object> set = new TreeSet<>();

        XIAOAN xiaoan1 = new XIAOAN();
        XIAOAN xiaoan2 = new XIAOAN();
        XIAOAN xiaoan3 = new XIAOAN();


        set.add(xiaoan1);
        set.add(xiaoan2);
        set.add(xiaoan3);

        System.out.println(set);

    }


}
