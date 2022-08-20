import cn.axg.study.commons.model.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TestOptional {

    @Test
    public void test(){

//        String str = null;
//
//        System.out.println(Optional.ofNullable(str).orElseGet(()-> "i love you"));
//        User user = null;
//        System.out.println(user.getName());

//        User user1 = Optional.ofNullable(user).orElseGet(()->new User());
//        System.out.println(user1);

        String str = "1001:-10,1002:20,1004:60,1006:73";

        String[] split = str.split(",");

        Map<String,String> map = new HashMap<>();

        for (String s : split) {
            String[] split1 = s.split(":");
            for (int i = 0; i < split1.length; i = i+2) {
                if(i == (split.length -1)){
                    break;
                }
                map.put(split1[i],split1[i+1]);
            }
        }
        map.forEach((k,v)->{
            System.out.println("k===>"+k);
            System.out.println("v====>"+v);
        });

    }


}
