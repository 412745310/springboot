package com.chelsea.springboot.component.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chelsea.springboot.component.service.ComponentService;

@RestController
public class ComponentTestController {

    @Autowired
    private ComponentService exampleService;

    @GetMapping("/input")
    public String input(String word) {
        return exampleService.wrap(word);
    }
}
