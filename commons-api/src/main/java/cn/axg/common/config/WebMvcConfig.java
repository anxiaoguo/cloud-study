package cn.axg.common.config;

import cn.axg.common.interceptor.RequestLimitingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 请求限流拦截器
     */
    @Resource
    protected RequestLimitingInterceptor requestLimitingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 请求限流
        registry.addInterceptor(requestLimitingInterceptor).addPathPatterns("/**");
    }

}