package com.graduation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.graduation.mapper")
//@ComponentScan(basePackages = { "**.controller" })
public class HsApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(HsApplication.class, args);
	}

}