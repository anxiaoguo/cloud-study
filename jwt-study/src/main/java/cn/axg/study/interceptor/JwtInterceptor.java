package cn.axg.study.interceptor;

import cn.axg.common.api.CommonResult;
import cn.axg.study.utils.JwtUtils;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户认证拦截 JWT
 */
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入拦截器JwtInterceptor~~~~~~~");
        String msg = null;
        //从请求头中获取token
        String token = request.getHeader("token");
        if(!StringUtils.hasText(token)){
            msg = "请检查token";
            String s = new ObjectMapper().writeValueAsString(CommonResult.failed(msg));
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(s);
            return false;
        }
        try {
            //验证令牌
            JwtUtils.verifyToken(token);
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            msg = "无效签名";
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            msg = "token失效";
        }catch (AlgorithmMismatchException e){
            e.printStackTrace();
            msg = "token算法不一致";
        }catch (Exception e){
            log.error("发现未知错误：[{}]",e.getMessage());
            e.printStackTrace();
        }
        String s = new ObjectMapper().writeValueAsString(CommonResult.failed(msg));
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(s);
        return false;
    }


}
