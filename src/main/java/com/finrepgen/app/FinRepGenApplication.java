package com.finrepgen.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.finrepgen.*")
public class FinRepGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinRepGenApplication.class, args);
	}

}
