package com.chelsea.springboot_first_application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chelsea.springboot_first_application.ApplicationUtil;
import com.chelsea.springboot_first_application.domain.Person;
import com.chelsea.springboot_first_application.service.PService;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String hello(){
		return "hello world";
	}
	
    @RequestMapping("/test")
	public void test(String serviceName) throws InterruptedException {
        PService pService1 = (PService) ApplicationUtil.getApplicationContext()
                .getBean("AService");
        pService1.setServiceName(serviceName);
        Thread.sleep(5000);
        pService1.test();
	}
    
    @RequestMapping("/testList")
    public void testList(@RequestBody Person person) {
        List<Integer> hobby = person.getHobby();
        System.out.println(person.getName());
        System.out.println(person.getHobby().size());
        for (Integer s : hobby) {
            System.out.println(s);
        }
    }

}
