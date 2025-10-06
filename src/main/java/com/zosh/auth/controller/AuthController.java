package com.zosh.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	

	    @GetMapping("/")
	    public String homePage() {
	      return "success";
	    }

	}

