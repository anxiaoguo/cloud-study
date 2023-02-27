package cn.axg.common.interceptor;

import cn.axg.common.annotation.RepeatSubmit;
import cn.axg.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
@Component
public abstract class RepeatSubmitInterceptor extends HandlerInterceptorAdapter {

    /**
     * 方法执行前的拦截处理
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("防止重复提交加载了");
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            RepeatSubmit annotation = method.getAnnotation(RepeatSubmit.class);
            if (annotation != null) {
                if (this.isRepeatSubmit(request)) {
                    throw new ApiException("不允许重复提交，请稍后再试");
                }
            }
            //继续执行下一个拦截器
            return true;
        } else {
            return super.preHandle(request, response, handler);
        }
    }

    public abstract boolean isRepeatSubmit(HttpServletRequest request);
}
