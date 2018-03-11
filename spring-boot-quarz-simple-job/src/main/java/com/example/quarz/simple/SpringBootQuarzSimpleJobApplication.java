package com.example.quarz.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
// @EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
// HibernateJpaAutoConfiguration.class })

public class SpringBootQuarzSimpleJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootQuarzSimpleJobApplication.class, args);
	}
}
