package com.victor;

import com.victor.config.datasource.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@Import({DynamicDataSourceRegister.class}) // 注册动态多数据源
@ServletComponentScan
@EnableAsync
public class SpringbootMybatisShiroApplication {


	public static void main(String[] args) {

		SpringApplication.run(SpringbootMybatisShiroApplication.class, args);
		System.out.println("======== Spring Boot Success(成功) ========");
	}
}
