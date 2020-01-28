package com.mthree;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class SpringBootWebMvcDdemoApplication {

	// Main isnt called by name its called by a servlet so fuck main
	// Spring boot however, uses main method as the entry point.
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootWebMvcDdemoApplication.class, args);
	}

}

