package com.springboot.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@MapperScan("com.springboot.springboot.dao.mapper")
public class BuildingClubApplication {
	public static void main(String[] args) {
		SpringApplication.run(BuildingClubApplication.class, args);
	}
}
