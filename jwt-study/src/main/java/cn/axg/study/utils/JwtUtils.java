package cn.axg.study.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    //签名secret
    private static final String SIGN = "caiud*#()#121&(*";
    //token 失效时间
    private static final int EXPIRE_TIME = 7;



    /**
     * 根据用户信息生成token
     */
    public static String getToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        return builder.withExpiresAt(getDate())
                .sign(Algorithm.HMAC256(SIGN));
    }

    /**
     * 验证token是否有效,没有异常信息就有效
     */
    public static void verifyToken(String token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SIGN)).build();
        jwtVerifier.verify(token);
    }


    /////////////////////////////私有方法，写在以下///////////////////////////////////////////
    /**
     * 获取一个指定长度的时间 默认7天
     * @return
     */
    private static Date getDate() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR_OF_DAY, EXPIRE_TIME);
        return instance.getTime();
    }

}
