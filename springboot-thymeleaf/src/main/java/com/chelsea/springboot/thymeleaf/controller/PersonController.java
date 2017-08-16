package com.chelsea.springboot.thymeleaf.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.chelsea.springboot.thymeleaf.form.PersonForm;

@Controller
public class PersonController extends WebMvcConfigurerAdapter {

	@GetMapping("/show-form")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	@PostMapping("/check-person-info")
	public String checkPersonInfo(@Valid PersonForm personForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		return "redirect:/result";
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/result").setViewName("result");
	}

}
