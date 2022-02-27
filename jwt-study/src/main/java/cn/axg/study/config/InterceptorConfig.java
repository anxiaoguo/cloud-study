package cn.axg.study.config;

import cn.axg.study.interceptor.JwtInterceptor;
import cn.axg.study.interceptor.Myinterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    //registery写的顺序就是拦截的先后顺序
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求
        String[] addPathPatterns = {"/**"};
        //不需要拦截的请求
        String[] excludePathPatterns = {"/user/login","/doc.html","/swagger-resources/**","/webjars/**","/v2/**","/favicon.ico","/swagger-ui.html/**"};
        registry.addInterceptor(new Myinterceptor2()).addPathPatterns("/**");
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
