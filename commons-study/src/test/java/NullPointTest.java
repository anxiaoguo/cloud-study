import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NullPointTest {


    @Test
    public void test(){
        String str = null;

        Integer a = 1000;
        Integer b = 1000;

        Integer c = 127;
        Integer d = 127;

        Integer m = -128;
        Integer n = -128;

        Integer y = -129;

        Integer x = -129;

        System.out.println(a == b);

        System.out.println(c == d);

        System.out.println(m == n);

        System.out.println(y == x);

        Integer t = null;
        Integer integer = Optional.ofNullable(t).orElseGet(() -> 0);

        System.out.println(3 == integer);


        List<String> list = Arrays.asList("2", "4", "5");
        List<String> collect = list.stream().filter(i -> !i.equals("5")).collect(Collectors.toList());
        System.out.println(collect);

    }

}
