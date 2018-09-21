package com.chelsea.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/sayHello")
	public String sayHello(){
		return "hello world111";
	}

}
