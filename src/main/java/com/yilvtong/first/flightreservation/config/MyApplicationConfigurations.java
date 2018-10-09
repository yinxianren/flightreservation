package com.yilvtong.first.flightreservation.config;


import com.yilvtong.first.flightreservation.tool.collections.MyApplications;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class MyApplicationConfigurations {


    @Lazy
    @Bean
    public MyApplications myApplications(){

        return MyApplications.getMyApplicationsInstance();
    }


}
