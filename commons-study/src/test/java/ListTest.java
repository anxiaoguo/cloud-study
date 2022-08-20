import org.junit.Test;

public class ListTest {


    @Test
    public void test() {


//        String str = "今天我要重新给力，dasasc增长的敬意";
//
////        int length = str.length();
////        System.out.println(length);
//
//        String s = hiddenStr(str, 1, 1, "*");
//        System.out.println(s);

        String str2 = "测试代理1/员工/";

        System.out.println(str2.contains("员工"));


//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println(list.size());

//        Integer integer = list.get(3);
//        System.out.println(integer);

//        Random random = new Random();
//        int i = random.nextInt(3);
//        System.out.println(i);



    }

    public static String hiddenStr(String str, Integer startIndex, Integer endIndex, String encryptionStr) {
        if (str.length() <= 1) {
            return str;
        }
        if (null == encryptionStr) {
            encryptionStr = "";
        }
        String xxStr = "";
        String lenStr = str.trim().substring(startIndex, str.length() - endIndex);
        for (int i = 0, len = lenStr.length(); i < len; i++) {
            xxStr += encryptionStr;
        }
        xxStr = str.replaceFirst(lenStr, xxStr);
        return xxStr;
    }


}
