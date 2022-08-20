import org.junit.Test;

import java.util.Calendar;

public class TestString {

    @Test
    public void test() {
//        String str = "chsidcscds.pdf";
//        String substring1 = str.substring(str.length() - 4);
//        System.out.println(substring1);

        Calendar c = Calendar.getInstance();

        int firstDayOfWeek = c.getFirstDayOfWeek();
        System.out.println(firstDayOfWeek);

//        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
//        if (day_of_week == 0)
//            day_of_week = 7;
//        c.add(Calendar.DATE, -day_of_week + 1);
//
//        System.out.println(c.getTime());


    }

}
