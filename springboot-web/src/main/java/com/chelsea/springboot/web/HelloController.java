package com.chelsea.springboot.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @Value("${foo}")
    private String foo;
    
    @Value("${age}")
    private String age;
	
	@RequestMapping("/sayHello")
	public String sayHello(){
		return "hello world " + foo + "," + age;
	}

}
