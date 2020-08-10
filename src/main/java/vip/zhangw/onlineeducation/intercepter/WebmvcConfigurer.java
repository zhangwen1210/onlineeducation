package vip.zhangw.onlineeducation.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: onlineeducation->WebmvcConfigurer
 * @description:拦截器配置类
 * @author: zhangwen
 * @create: 2020-07-27 17:03
 **/
@Configuration
public class WebmvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api/v1/pri/**")
        .excludePathPatterns("/api/v1/pri/user/register","/api/v1/pri/user/login");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
