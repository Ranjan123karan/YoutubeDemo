package com.youtube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import jakarta.servlet.annotation.WebServlet;
@WebServlet
public class ServletInitializer extends SpringBootServletInitializer {
	
	 public static void main(String[] args) {
	        SpringApplication.run(YoububeApplication.class, args);
	    }

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(YoububeApplication.class);
	}

}
