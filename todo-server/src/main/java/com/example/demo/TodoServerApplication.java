package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class TodoServerApplication {

	@Value("${todo-config}")
	String todoConfig;
	
	@Value("${service.instance.name}")
	private String instance;

	public static void main(String[] args) {
		SpringApplication.run(TodoServerApplication.class, args);
	}

	@GetMapping("/todo-config")
	public String showLuckyWord() {
		return "The todoConfig is: " + todoConfig;
	}
	
	@RequestMapping("/")
	public String message() {
		return "Hello from " + instance;
	}

}
