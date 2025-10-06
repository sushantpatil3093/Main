package com.zosh.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	

	    @GetMapping("/")
	    public String homePage() {
	        return "home"; // home.jsp or home.html
	    }

	    @GetMapping("/login")
	    public String loginPage() {
	        return "login"; // login.jsp or login.html
	    }

	    @GetMapping("/user/welcome")
	    public String userWelcomePage() {
	        return "welcome"; // welcome.jsp or welcome.html
	    }
	}

