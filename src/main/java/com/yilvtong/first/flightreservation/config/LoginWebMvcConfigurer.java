package com.yilvtong.first.flightreservation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration   //开放中注释掉，事件应用要打开
public class LoginWebMvcConfigurer implements WebMvcConfigurer {


    //跳过拦截对象
    private static List<String> pathList= Arrays.asList(
            "/",
            "/test/**/*",
            "/ueditor/**/*",
            "/home/valicode",
            "/home/imageCode",
            "/home/login",
            "/**/*.svg",
            "/**/*.css",
            "/**/*.js",
            "/**/*.db",
            "/**/*.html",
            "/**/*.gif",
            "/**/*.png",
            "/**/*.jpg",
            "/**/*.jpeg");


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptorAdapter()).addPathPatterns("/**")
                .excludePathPatterns(pathList);//这些是不拦截的
    }




}
