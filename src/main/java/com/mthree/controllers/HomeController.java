package com.mthree.controllers;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mthree.models.Student;
import com.mthree.services.StudentService;

@Controller
public class HomeController {

	// Write all request mapping methods.
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
	public String home()
	{
		return "home"; // This string value represents a view name (jsp file name)
	}
	
	// Type of mapping
		@RequestMapping("/hi")
		public void sayHello(HttpServletRequest request, HttpServletResponse response) throws Exception
		{
			PrintWriter pw = response.getWriter();
			
			pw.println("Hello!!");
		}
		
		@RequestMapping(path="/register", method=RequestMethod.GET) // Can bet GET,POST, DELETE etc in the same controller
		public String registerProcess(@RequestParam("name") String name, @RequestParam("email") String email) {
			
			
			return "home";
		}
		
		//http://localhost:8080/register2?id=1&name=chrismate
		// @ModelAttribute, input values will be sent into student! So the id and name will be sent into student!
		// The id and name must have identical names otherwise it cannot autowire.
		@RequestMapping(path="/register2", method=RequestMethod.GET) // Can bet GET,POST, DELETE etc in the same controller
		public String registerProcess2(@ModelAttribute Student s) {
			System.out.println(s.getId() + " " + s.getName());
			return "home";
		}
		
		@RequestMapping(path="/register3", method=RequestMethod.GET) // Can bet GET,POST, DELETE etc in the same controller
		public ModelAndView registerProcess3(@ModelAttribute Student s) {
			System.out.println(s.getId() + " " + s.getName());
			// You can bind an object by look up, s1 is key, s is the value.
			ModelAndView mv = new ModelAndView("welcome","student",s);
			mv.addObject("today", LocalDateTime.now());
			// so this mv can read student objects and date obejcts.
			return mv;
		}
		
		@RequestMapping(path="/register4", method=RequestMethod.GET) // Can bet GET,POST, DELETE etc in the same controller
		public ModelAndView registerProcess4(@ModelAttribute Student s) {
			Student persistedStudentObj = studentService.saveStudentObject(s);
			ModelAndView mv;
			if(persistedStudentObj != null) {

				// You can bind an object by look up, s1 is key, s is the value.
				mv = new ModelAndView("welcome","student",s);
				mv.addObject("today", LocalDateTime.now());
				// so this mv can read student objects and date objects.
			}else
			{
				mv = new ModelAndView("welcome","student", "Unable to register.");
				mv.addObject("today", LocalDateTime.now());

			}
			return mv;
		}		
}
