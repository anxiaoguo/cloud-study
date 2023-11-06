import cn.axg.study.commons.model.XIAOAN;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class InvokeTest {



    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> aClass = null;
        try {
            aClass = Class.forName("cn.axg.study.commons.model.XIAOAN");
        } catch (ClassNotFoundException e) {
            System.out.println("没有找到类啊~~~~");
        }

        if(aClass != null){

            Constructor<?> constructor = aClass.getDeclaredConstructor();

            XIAOAN xiaoan = (XIAOAN) constructor.newInstance();

            xiaoan.setAge("18");
            System.out.println(xiaoan);


        }



    }

    @Test
    public void test2(){

        Vector<String> v = new Vector<>();

        v.add("xxx");

        List<String> list = new ArrayList<>();

        list.add("cd");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("cacxs");

    }


}
