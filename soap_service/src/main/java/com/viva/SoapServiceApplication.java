package com.viva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.viva.*")
public class SoapServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapServiceApplication.class, args);
	}

}
