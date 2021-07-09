package com.test.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
	@GetMapping("/helloworld")
	public String hello() {
	return "Hello World!";
	}
}
