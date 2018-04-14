package com.learning.appliancestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApplianceStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplianceStoreApplication.class, args);
	}
}
