package com.spring.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

	 @GetMapping("/hello")
	    public String hello() {
	        return "Hello, World!";
	    }
	 
	 @PostMapping("post")
	 public String postMethodCheck(@RequestBody String arg) {
		 return arg;
	 }
}
