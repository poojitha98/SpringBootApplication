package com.springboot.Resilience4J;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@SpringBootApplication

public class Resilience4JProjectApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(Resilience4JProjectApplication.class, args);
	}
  
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	}

