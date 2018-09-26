package com.yilvtong.first.flightreservation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@MapperScan("com.yilvtong.first.flightreservation.mapper.*")//将项目中对应的mapper类的路径加进来就可以了
@SpringBootApplication
public class FlightreservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightreservationApplication.class, args);
	}









}
