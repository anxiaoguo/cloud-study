package cn.axg.study.commons.utils;

import org.junit.Test;
import org.springframework.util.StringUtils;

public class SpringUtilsTest {



    /**
     * StringUtils
     */
    @Test
    public void test(){

        String str = "";
        //字符串判空 str != null && !str.isEmpty() && containsText(str)
        boolean b = StringUtils.hasText(str);

//        StringUtils.pathEquals()

    }
}
