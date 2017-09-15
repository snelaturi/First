package com.test.usecases.usecase14;

import java.util.List;

public interface StudentDataAccessInterface {
	
		   public List<Student> getAllStudents();
		   public Student getStudent(int rollNo);
		   public void updateStudent(Student student);
		   public void deleteStudent(Student student);
		
}
