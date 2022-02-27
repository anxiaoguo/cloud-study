package cn.axg.study.jwt.jdk;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class TestJwt {

    /**
     * 生成token(必要的)
     */
    @Test
    public void test() {

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 120);

        String token = JWT.create()
                //claim里面就是负载内容
                .withClaim("username", "jack")
                .withClaim("id", "89")
                //设置token失效时间
                .withExpiresAt(instance.getTime())
                //指定token加密算法
                .sign(Algorithm.HMAC256("caiud*#()#121&(*"));

        System.out.println(token);

    }

    /**
     * 验证token是否有效（必要的）
     */
    @Test
    public void test2() {
        //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("caiud*#()#121&(*")).build();
        //去验证token
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6Ijg5IiwiZXhwIjoxNjQ1ODA0Mzk5LCJ1c2VybmFtZSI6ImphY2sifQ.RAvlPsJo6x0IkgPuZfEqQ3JQOyhkzjeT2xAvoClqqsY");
        System.out.println(verify.getClaim("username").asString());
        System.out.println(verify.getClaim("id"));
    }

    /**
     * 通过token获取用户信息
     */

    public String getUserName(String token) {
        //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("caiud*#()#121&(*")).build();
        //去验证token
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6Ijg5IiwiZXhwIjoxNjQ1ODA0Mzk5LCJ1c2VybmFtZSI6ImphY2sifQ.RAvlPsJo6x0IkgPuZfEqQ3JQOyhkzjeT2xAvoClqqsY");
        return verify.getClaim("username").asString();
    }


}
