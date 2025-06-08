package com.api.apienvio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "com.api.apienvio")
public class ApienvioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApienvioApplication.class, args);
	}

}
