package com.chelsea.springboot.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    
    @Value("${foo}")
    private String foo;
    
    @Value("${age}")
    private String age;
	
	@RequestMapping("/sayHello")
	@ResponseBody
	public String sayHello(){
		return "hello world " + foo + "," + age;
	}
	
	@RequestMapping("/hello1")
	public String hello1() {
	    return "redirect:http://localhost:8081/springboot-web/hello2";
	}
	
	@RequestMapping("/hello2")
    public String hello2() {
        return "redirect:index.jsp";
    }

}
