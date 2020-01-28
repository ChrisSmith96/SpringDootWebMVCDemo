package com.mthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.models.Student;
import java.util.List;
// Entity represents an entity.
// The id is int not Integer, but cant have that in a repository.
// This automatically makes the database! Spring provides the implementation.
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{

	// User- definted methods using patterns
	
	//It will auto wire to the 'name' variable, so the naming convension is very important
	public List<Student> findStudentByName(String name);

	//Same but the name must contain the value not excatly the value;
	public List<Student> findStudentByNameLike(String name);
	
	// cannot use *, must be s, and you must use name of the variable in the query!
	// :name is placeholder which would be replaced with the actual input value.
	// To substitue the value into the placeholder use @Param annotation
	@Query(value="SELECT s from Student s WHERE s.name = :name")
	public List<Student> getAllStudentsByName(@Param("name") String name);
	
	// name of table used here 'student' in order to use the wild card * operator
	// This is an example of a native query (standard sql).
	@Query(value="SELECT * from student s WHERE s.name = :name", nativeQuery =true)
	public List<Student> getAllStudentsByName2(@Param("name") String name);
	
	// can call* or the following. Use table alias to access the coumn names.
	@Query(value = "SELECT s.id,s.name,c.courseTitle from Student s INNER JOIN s.courses c ON s.id = c.id")
	public List<Object> getStudentsAlongWithCourse();
	
}
