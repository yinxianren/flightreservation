package com.yilvtong.first.flightreservation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class LoginWebMvcConfigurer implements WebMvcConfigurer {


    //跳过拦截对象
    private static List<String> pathList= Arrays.asList(
            "/",
            "/home/valicode",
            "/home/imageCode",
            "/home/login",
            "/**/*.svg",
            "/**/*.css",
            "/**/*.js",
            "/**/*.db",
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
