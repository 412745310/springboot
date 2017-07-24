package com.chelsea.springboot_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = { "classpath:application-context.xml" })
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
