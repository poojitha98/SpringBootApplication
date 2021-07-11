package com.springboot.Resilience4J.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/send")
public class testController {
	private static final String WELCOME_ERROR = "welcomeService";
	
	//Payment service need to be Up and running for this to work and down to show fallback.
	
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/helloworld")
	@CircuitBreaker(name = WELCOME_ERROR, fallbackMethod = "welcomeFallBack")
	public ResponseEntity<String> hello() {
		String response=restTemplate.getForObject("http://localhost:9191/payment/14", String.class);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}

	public ResponseEntity<String> welcomeFallBack(Exception e) {
		return new ResponseEntity<String>("Service is down...",HttpStatus.OK);
	}

}
