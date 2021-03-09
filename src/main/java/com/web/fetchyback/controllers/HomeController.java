package com.web.fetchyback.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HomeController {

    @GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
}
