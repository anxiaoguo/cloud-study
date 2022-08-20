import cn.axg.common.config.AnimalEnum;
import org.junit.Test;

import java.util.Arrays;

public class EnumTest {

    @Test
    public void test(){
//        System.out.println(AnimalEnum.XIAO_HEI.getName());
//        AnimalEnum[] values = AnimalEnum.values();
//
//        System.out.println();
//        for (AnimalEnum value : AnimalEnum.values()) {
//            System.out.println(value);
//        }

//        Arrays.stream(AnimalEnum.values()).forEach(i-> System.out.println(i.getName()));
        AnimalEnum nameByNumber = AnimalEnum.getNameByNumber(4);

        System.out.println(nameByNumber);
    }
}
