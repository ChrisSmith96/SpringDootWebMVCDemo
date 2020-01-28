package com.mthree.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.models.Student;
import com.mthree.services.StudentService;

@RestController
public class StudentContoller {

	@Autowired
	private StudentService studentService;
	
	
	// Rest API end-points
	
	@RequestMapping("/getAllStudents")
	public List<Student> getAllStudents()
	{
		List<Student> students = new ArrayList<>();
		
		students.add(new Student(1,"Wiley"));
		students.add(new Student(2,"Aitch"));
		students.add(new Student(3,"Stormzy"));
		
		return students;
	}
	
	@RequestMapping("/allStudents")
	public List<Student> loadStudents()
	{
		return studentService.loadAllStudents();
	}
	
	@GetMapping("/studentsWithCourses")
	public List<Object> studentsAndCourses(){
		return studentService.getAllStudentsAndCourses();
	}
	
}
