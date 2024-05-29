package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.controller.CustomInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private CustomInterceptor customInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor)
                .addPathPatterns("/**")  // Áp dụng Interceptor cho tất cả các đường dẫn
                .excludePathPatterns("/no-login","nhan-vien","/dang-nhap","hoa-don","hoa-don-chi-tiet");  // Loại trừ các đường dẫn không cần kiểm tra
    }
}
