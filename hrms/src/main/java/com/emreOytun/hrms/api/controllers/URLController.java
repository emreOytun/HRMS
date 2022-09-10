package com.emreOytun.hrms.api.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class URLController {
	
	 @GetMapping("/getBaseUrl")
	    public String getBaseUrl(HttpServletRequest request) {
		 String baseUrl = ServletUriComponentsBuilder
	                .fromRequestUri(request)
	                .replacePath(null)
	                .build()
	                .toUriString();

	        return baseUrl;
	    }
	 
}
