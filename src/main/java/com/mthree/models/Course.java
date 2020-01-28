package com.mthree.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Course {

	@Id
	private int courseID;
	
	private String courseTitle;
	
	// This isnt essential, it would create a bridge table without it, we do not want that we just want two tables with a foreign key.
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student id;
	
	public int getCourseID() {
		return courseID;
	}
	
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	
	public String getCourseTitle() {
		return courseTitle;
	}
	
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	
	public Course(int courseID, String courseTitle) {
		super();
		this.courseID = courseID;
		this.courseTitle = courseTitle;
	}
	
	public Course() {}
}
