import cn.axg.study.commons.model.LinkMethods;
import cn.axg.study.commons.model.MALI;
import cn.axg.study.commons.model.Person;
import cn.axg.study.commons.model.XIAOAN;
import org.junit.Test;

import javax.activation.CommandInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

public class TestString {




    @Test
    public void test666() throws UnsupportedEncodingException {

//            System.out.println(URLEncoder.encode("孤傲苍狼", "UTF-8"));
//            String decode = URLDecoder.decode("%E5%AD%A4%E5%82%B2%E8%8B%8D%E7%8B%BC","utf-8");
//            System.out.println(decode);

//        String encoded = URLEncoder.encode("Hello World!", "UTF-8");
//        System.out.println(encoded);  // 输出：Hello+World%21


        // URL解码示例
        String decoded = URLDecoder.decode("Hello+World%21", "UTF-8");
        System.out.println(decoded);  // 输出：Hello World!
//        String[] str = null;
//
//        List<String> collect = Arrays.stream(str).collect(Collectors.toList());
//        System.out.println(collect);

    }


    @Test
    public void test() {

        LinkedList list = new LinkedList();
//
//        list.add("apple");
//        list.add("banana");
//        list.add("apple");
//
////        System.out.println(list);
//
//
//
//        Iterator iterator = list.iterator();
//
//        while (true){
//            if(iterator.hasNext()){
//                Object next = iterator.next();
//                System.out.println(next);
//            }else {
//                return;
//            }
//        }


        LinkMethods<String> linkMethods = new LinkMethods<>();

        linkMethods.linkLast("aaaa");

        linkMethods.linkLast("bbb");

        linkMethods.linkLast("ccc");
        linkMethods.linkLast("ddd");

        linkMethods.linkLast("eee");


        System.out.println(linkMethods);

    }


    @Test
    public void test88() {


        Map<XIAOGUO,String> map = new TreeMap<>((x,y)->x.getAge()-y.getAge());

        map.put(new XIAOGUO("h",12,32),"2432");
        map.put(new XIAOGUO("w",18,33),"2534");

        System.out.println(map);

//        Set set = new LinkedHashSet();
//
//        set.add("123");
//        set.add(453);
//        set.add(new XIAOGUO());
//
//        System.out.println(set);
//        XIAOGUO xiaoguo = new XIAOGUO();
//        xiaoguo.setName("21");
//        XIAOGUO xiaoguo1 = new XIAOGUO();
//
//        System.out.println(xiaoguo.equals(xiaoguo1));
//
//        System.out.println(xiaoguo1.hashCode());

//        XIAOGUO xiaoding1 = new XIAOGUO("小丁",27,20);
//        XIAOGUO xiaoding2 = new XIAOGUO("小丁2",27,19);
//        XIAOGUO xiaoding3 = new XIAOGUO("小丁3",29,18);
//
//        Set<XIAOGUO> set = new TreeSet<>((x,y)->{
//            if(x.getAge() > y.getAge()){
//                return 1;
//            }else if(x.getAge()==y.getAge()) {
//                if(x.getNumber() > y.getNumber()){
//                    return 1;
//                }else {
//                    return -1;
//                }
//            }else {
//                return -1;
//            }
//        });
//        set.add(xiaoding1);
//        set.add(xiaoding2);
//        set.add(xiaoding3);
//
//        System.out.println(set);


//        HashMap hashMap = new HashMap();
//        hashMap.put()





        //list是有序的 按照存储顺序排列 是可以重复的
//        List list = new ArrayList<>();
//        list.add("dwdw");
//        list.add(12);
//        list.add(new Person());
//        list.add("dwdw");
//
//        System.out.println(list);

        //HashSet是没有顺序的 并且不能存储重复元素
//        Set set = new HashSet();
//        set.add("hello");
//        set.add(12321);
//        set.add(new Person());
//        set.add("hello");
//        set.add(23);
//        System.out.println(set);

//        Set set = new TreeSet();
//        set.add(123);
//        set.add("345");
//        set.add(1);
//
//        System.out.println(set);


//        HashMap<String,Object> map = new HashMap<>();
//
//        map.put("a","123");
//
//        map.put("a","234");
//
//        map.put("a",133);
//
//        System.out.println(map);

        //String 和 Integer 都实现了Comparable接口
//        String str1 = "abcdefg5";
//        String str2 = "abcdefg12";
//        Integer a = 123;
//
//        System.out.println(str1.compareTo(str2));


    }


}
