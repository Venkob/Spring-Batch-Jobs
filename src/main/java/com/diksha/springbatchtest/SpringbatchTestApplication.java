package com.diksha.springbatchtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources(value = {
@PropertySource(ignoreResourceNotFound = false, value = "classpath:application.yml")})
public class SpringbatchTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbatchTestApplication.class, args);
	}


}