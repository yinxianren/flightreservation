package com.yilvtong.first.flightreservation.config;


import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@Configuration
public class MultipartConfig {


    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
        factory.setMaxFileSize("3MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("30MB");
        //Sets the directory location wherefiles will be stored.
        //factory.setLocation("路径地址");
        return factory.createMultipartConfig();
    }








}
