package com.mthree.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
// ^ Not the native approach.
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Entity now kind of thinks of this as a table, with params etc.
@Entity
public class Student {

	@Id
	// This will auto incrememnt in the databse rather tahn populating the vlues manually.
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
//@Column(name = "student_name")
	private String name;
	
	// by default it will load students and thats it, thats lazy, eager fetch with request all student details, courses etc.
	@OneToMany(fetch=FetchType.EAGER, mappedBy="id") // mapped by is acolumn name, foreign key, mapping student to course.
	private List<Course> courses;
	
	public Student() {}
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
