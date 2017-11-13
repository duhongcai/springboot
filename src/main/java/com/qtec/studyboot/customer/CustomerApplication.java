package com.qtec.studyboot.customer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "com.qtec.studyboot.customer.dao")
public class CustomerApplication extends SpringBootServletInitializer{

	//启动servlet支持
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CustomerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
}
