import cn.axg.study.commons.utils.SpringUtilsTest;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.sun.org.apache.bcel.internal.generic.I2B;
import org.junit.Test;

import javax.xml.transform.Source;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class TestCalender {


    @Test
    public void test() throws ParseException {

//        //订单号的时间
//        c.set();
//        //订单号时间加上两天和当前时间做对比
//        c.add(Calendar.DATE,2);
//        Calendar now = Calendar.getInstance();
//        if(c.equals(now) || c.before(now)){
//            return false;
//        }
//        return true;

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//
//        String format = simpleDateFormat.format(new Date());
//        System.out.println(format);
//
//        Date parse = null;
//        try {
//            parse = simpleDateFormat.parse(format);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(parse);

//        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("HH:mm:ss");
//        Date parse = simpleDateFormat.parse(time);
//        //new方式创建
//        DateTime dateTime = new DateTime(time, DatePattern.NORM_TIME_PATTERN);
//        System.out.println("dateTime"+dateTime);
//        long time1 = dateTime.getTime();
//        System.out.println(time1);
//        System.out.println(dateTime);

        DateTime now = DateTime.now();
        String s = now.toString();
        String year = s.substring(0, 4);
        String month = s.substring(5, 7);
        String day = s.substring(8, 10);
        String time = "21:37:37";
        StringBuffer sb = new StringBuffer();
        sb.append(year).append("-").append(month).append("-").append(day).append(" ").append(time);
        String s1 = sb.toString();
        DateTime dateTime = new DateTime(s1, DatePattern.NORM_DATETIME_FORMAT);
        long time2 = now.getTime();
        long time1 = dateTime.getTime();

        System.out.println(time2);
        System.out.println(time1);
        System.out.println(time1-time2);
    }

    @Test
    public void test2(){
//        String time = "2022-03";
//
//        String year = time.substring(0, 4);
//        String month = time.substring(5,7);
//        System.out.println(year);
//        System.out.println(month);

//        Calendar instance = Calendar.getInstance();
//        instance.set(2022,03-1,01,0,0,0);
//        Date time = instance.getTime();
//
//        System.out.println(instance.getTime());
//        String format = new SimpleDateFormat("yyyy-MM").format(new Date());
//        String year = format.substring(0, 4);
//        String month = format.substring(5, 7);

//        Calendar instance = Calendar.getInstance();
//        instance.set(Integer.parseInt(year),Integer.parseInt(month),0);
//        int i = instance.get(1);
//        int i1 = instance.get(2);
//        String year1 = i+"";
//        String month1 = i1+"";
//        if(i1 < 10){
//            month1 = "0" + i1;
//        }
//        System.out.println(year1);
//        System.out.println(month1);
//        List<Integer> collect = Arrays.asList(342, 453, 454352, 3423);
//        StringBuffer sb = new StringBuffer();
//        for (Integer aLong : collect) {
//            sb.append(aLong).append(",");
//        }
//        String keywordStr = sb.deleteCharAt(sb.length() - 1).toString();
//        System.out.println(keywordStr);
//        String s = "2022-04-01";
//        String substring = s.substring(0, 7);
//        System.out.println(substring);

//        Calendar instance = Calendar.getInstance();
//        instance.setTime(new Date());
//
////        Calendar instance1 = Calendar.getInstance();
////        instance1.setTime(new Date());
//        int i1 = instance.get(Calendar.YEAR);
//
//        int i = instance.get(Calendar.MONTH);
//        System.out.println(i1);
//        Calendar instance1 = Calendar.getInstance();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(instance1.getTime()));
//
//        Date date = new Date();
//        Calendar instance = Calendar.getInstance();
//        instance.setTime(date);
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(instance.getTime()));
//        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
//        String s = RandomUtil.randomNumbers(4);
//        System.out.println(s);
//        System.out.println(time);

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,3);
        long timeInMillis = instance.getTimeInMillis();
        System.out.println(timeInMillis/1000);
//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//
//        System.out.println(set.contains(1));

    }


    @Test
    public void test3() throws ParseException {
        //当前时间
//        Date time = Calendar.getInstance().getTime();
//
//        Calendar instance = Calendar.getInstance();
//        instance.add(Calendar.DATE,10);
//        instance.setTime(instance.getTime());
//
//        int i = daysBetween(time, instance.getTime());
//        System.out.println(i);

//        Calendar instance1 = Calendar.getInstance();
//        instance1.set(2022,8,26);
//        instance1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(instance1.getTime())));
//
//        System.out.println(instance1.getTime());

        int num = 100;

        num-=10;
        System.out.println(num);

    }

    public static int daysBetween(Date smdate,Date bdate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }


}
