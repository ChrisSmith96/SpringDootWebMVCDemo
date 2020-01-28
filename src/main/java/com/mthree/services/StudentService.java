package com.mthree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.models.Student;
import com.mthree.repositories.StudentRepository;

@Service
public class StudentService 
{

	// Business logic and method.
	
	// Bridge between the controller and the repository.
	@Autowired
	private StudentRepository studentRepository;
	
	// HI JENKINS 
	
	public Student saveStudentObject(Student s)
	{
		return studentRepository.save(s);
	}
	
	
	// auto implemented defined all
	public List<Student> loadAllStudents()
	{
		return studentRepository.findAll();
	}
	
	public List<Object> getAllStudentsAndCourses(){
		return studentRepository.getStudentsAlongWithCourse();
	}
}
