package com.victor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@MapperScan({"com.victor.sys.mapper.*"})
@SpringBootApplication
public class SpringbootMybatisShiroApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisShiroApplication.class, args);
		System.out.println("======== Spring Boot Success(成功) ========");
	}
}
