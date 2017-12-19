package com.victor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DynamicDataSourceRegister.class}) // 注册动态多数据源
public class SpringbootMybatisShiroApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisShiroApplication.class, args);
		System.out.println("======== Spring Boot Success(成功) ========");
	}
}
