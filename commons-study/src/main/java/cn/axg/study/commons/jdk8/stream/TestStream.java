package cn.axg.study.commons.jdk8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 该类涵盖了Stream类大部分API
 */
public class TestStream {

    /**
     * Stream forEach遍历数组 void accept(T t);
     */
    @Test
    public void test() {
        //定义一个集合
        List<Integer> integers = Arrays.asList(1, 3, 5, 7, 2, 32, 312, 31);
        integers.stream().forEach(integer -> System.out.println(integer));
    }

    /**
     * Stream filter 筛选属性 boolean test(T t);
     */
    @Test
    public void test2() {
        List<Integer> integers = Arrays.asList(1, 3, 5, 7, 2, 32, 312, 31);
        integers.stream().filter(i -> i > 10).forEach(integer -> System.out.println(integer));
    }

    /**
     * Stream distinct 去重
     */
    @Test
    public void test3() {
        List<Integer> integers = Arrays.asList(1, 3, 5, 7, 3, 1, 312, 31);
        integers.stream().distinct().forEach(integer -> System.out.println(integer));
    }

    /**
     * Stream map 映射 对元素进行进一步操作映射成一个新的流 R apply(T t);
     */
    @Test
    public void test4() {
        List<Integer> integers = Arrays.asList(1, 2, 4, 21);
        integers.stream().map(i -> {
            //返回一个结果
            return ++i;
        }).forEach(integer -> System.out.println(integer));
    }

    /**
     * Stream 把两个合并成一个
     */
    @Test
    public void test5() {
        Stream<List<Integer>> stream2 = Stream.of(Arrays.asList(1, 2, 4, 21), Arrays.asList(3, 45, 23, 3));
        stream2.flatMap(i -> i.stream()).forEach(integer -> System.out.println(integer));
    }

    /**
     * Stream reduce 一般就是求聚合 R apply(T t, U u);
     */
    @Test
    public void test6() {
        List<Integer> integers = Arrays.asList(1, 2, 4, 21);
        Optional<Integer> reduce = integers.stream().reduce((a, b) -> {
            return a > b ? a : b;
        });
        System.out.println(reduce.get());
    }

    /**
     * Stream collect 结合流生成不同的集合
     */
    @Test
    public void test7() {
        List<String> list = Arrays.asList("2", "e", "ds", "sd", "2");
        Set<String> collect = list.stream().collect(Collectors.toSet());
        collect.stream().forEach(i -> System.out.println(i));
    }

    /**
     * Stream count 求流中元素的个数
     */
    @Test
    public void test8() {
        List<String> list = Arrays.asList("2", "e", "ds", "sd", "2");
        long count = list.stream().count();
        System.out.println(count);
    }

    /**
     * Stream concat 合并流
     */
    @Test
    public void test9() {
        Stream<String> stream = Arrays.asList("2", "e", "ds", "sd", "2").stream();
        Stream<Integer> stream1 = Arrays.asList(2, 3, 4, 2).stream();
        Stream.concat(stream, stream1).forEach(i -> System.out.println(i));
    }

    /**
     * Stream anyMatch 判断的条件里，任意一个元素成功，返回true， boolean test(T t);
     */
    @Test
    public void test10() {
        Stream<String> stream = Arrays.asList("2", "e", "ds", "sed", "2").stream();
        boolean e = stream.anyMatch(i -> i.contains("e"));
        System.out.println(e);
    }

    /**
     * Stream allMatch 判断条件里的元素，所有的都是，返回true boolean  test(T t);
     */
    @Test
    public void test11() {
        Stream<String> stream = Arrays.asList("2e", "e", "des", "seed", "e2").stream();
        boolean e = stream.allMatch(i -> i.contains("e"));
        System.out.println(e);
    }

    /**
     * Stream generate T get();生成一个无限连续的无序流，流中的元素由用户定义的supplier函数生成
     * limit(3) 限制生成3个
     */
    @Test
    public void test12() {
        Stream.generate(() -> 10).limit(3).forEach(i -> System.out.println(i));
    }

    /**
     * Stream iterate 指定一个常量seed，生成从seed到常量 f 由限制的limit决定
     * 根据起始值seed(0)，每次生成一个指定递增值（n+1）的数，limit(5)用于截断流的长度，即只获取前5个元素。
     */
    @Test
    public void test13() {
        Stream.iterate(0, n -> n + 1).limit(10).forEach(i -> System.out.println(i));
    }

    /**
     * Stream limit 对流进行截取，只取用前n个
     */
    @Test
    public void test14() {
        Stream<String> stream = Arrays.asList("2e", "e", "des", "seed", "e2").stream();
        stream.limit(3).forEach(i -> System.out.println(i));
    }

    /**
     * Stream sorted 它使用自然顺序对流的元素进行排序。元素类必须实现Comparable接口
     */
    @Test
    public void test15() {
        Stream<String> stream = Arrays.asList("2e", "e", "des", "seed", "e2").stream();
        stream.sorted().forEach(i -> System.out.println(i));
    }

    /**
     * Stream sorted 自定义排序  int compare(T o1, T o2);
     */

    @Test
    public void test16() {
        Stream<Integer> stream = Arrays.asList(10, 4, 3, 5, 29, 23, 2132, 2, 34).stream();
        stream.sorted((o1, o2) -> o1 - o2).forEach(i -> System.out.println(i));
    }

    /**
     * Stream Builder 创建一个Stream构建器，创建后就可以使用其build方法构建一个Stream
     * 该方法跟Stream的of 和list.Stream 是一个道理
     */
    @Test
    public void test17() {
        Stream.Builder<Object> builder = Stream.builder();
        builder.add(1);
        builder.add(new Date());
        builder.add("csd");


        Stream<Object> build = builder.build();
        build.forEach(i -> System.out.println(i));
    }

}
