package com.moglix.studentmanagementsystem.service;

import com.moglix.studentmanagementsystem.dto.Student;

public interface StudentServInf {

	public Student addStudent(Student student);
	public Student updateStudent(String id, Student string);
	public Student getStudentById(String id);
	public String deleteStudentById(String id);
	public String deleteAllStudent();
	
}
