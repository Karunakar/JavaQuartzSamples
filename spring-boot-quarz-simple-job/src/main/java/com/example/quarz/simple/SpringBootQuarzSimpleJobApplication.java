package com.example.quarz.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ComponentScan(basePackages = "com")
// @EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
// HibernateJpaAutoConfiguration.class })
// @Component
public class SpringBootQuarzSimpleJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootQuarzSimpleJobApplication.class, args);
	}
}
