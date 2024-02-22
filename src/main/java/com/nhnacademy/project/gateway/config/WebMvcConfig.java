package com.nhnacademy.project.gateway.config;

import com.nhnacademy.project.gateway.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .addPathPatterns("/**") // 모든 요청에 인터셉터를 적용합니다.
                .excludePathPatterns("/login"); // 로그인 요청은 인터셉터를 적용하지 않습니다.
    }
}
