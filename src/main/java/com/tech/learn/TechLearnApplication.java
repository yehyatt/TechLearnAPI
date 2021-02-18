package com.tech.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TechLearnApplication
{

	public static void main(String[] args) {
		SpringApplication.run(TechLearnApplication.class, args);
	}
}
