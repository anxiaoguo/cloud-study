import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import org.omg.PortableInterceptor.INACTIVE;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    @org.junit.Test
    public void test(){
//        Long x = 3L;
//        System.out.println(!Arrays.asList(3L, 2L, 21L).contains(x));
//        Long x = 88888888L;
//
//        System.out.println(x.equals(88888888L));
//        DecimalFormat decimalFormat = new DecimalFormat("#.##");
//        String format = decimalFormat.format(new BigDecimal("1.26325"));
//        System.out.println(format);
//        String str = "[{\"val\":\"49\",\"name\":\"智能家居\"},{\"val\":\"28\",\"name\":\"农资绿植\"},{\"val\":\"23\",\"name\":\"运动户外\"}]";
//        System.out.println(str.contains("智能家居"));

//        Long s = 1000L;
//        System.out.println(s == 1000);

//        Integer integer = null;
//
//        if(integer != null && (integer.intValue() > 0)){
//            System.out.println("我去");;
//        }else {
//            System.out.println("哈哈哈");
//        }



    }

    @org.junit.Test
    public void test22(){

        Integer currentPage = 1;
        Integer pageSize = 10;

        setPages(currentPage,pageSize);

        System.out.println(currentPage);
        System.out.println(pageSize);
    }

    void setPages(Integer currentPage,Integer pageSize){
        currentPage = 3;
        pageSize = 4;
    }

    @org.junit.Test
    public void test4(){
//        Calendar instance1 = Calendar.getInstance();
//        instance1.add(Calendar.MINUTE,2);
//        System.out.println(getIntervalSeconds(new Date(), instance1.getTime()));
        BigDecimal b = new BigDecimal("70.00");

        System.out.println(new BigDecimal("1").subtract(b.divide(new BigDecimal("100"))));

    }


    /**
     * 当前时间之前的时间与当前时间相差多少秒
     * @param startDate 当前时间之前的时间 订单生成时间
     * @param endTime 订单生成时间+12小时
     * @return
     */
    public static int calLastedTime(Date startDate,Date endTime) {
        long nowDate = endTime.getTime();
        long startDateTime = startDate.getTime();
        int diffSeconds = (int) ((nowDate - startDateTime) / 1000);
        return diffSeconds;
    }


    public static double getIntervalSeconds(Date sd, Date ed) {
        return (double) (ed.getTime() - sd.getTime()) / 1000;
    }

}
