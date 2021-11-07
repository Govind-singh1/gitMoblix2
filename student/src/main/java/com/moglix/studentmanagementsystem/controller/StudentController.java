package com.moglix.studentmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moglix.studentmanagementsystem.dto.Student;
import com.moglix.studentmanagementsystem.service.StudentServInf;

@RestController
@RequestMapping("/sms")
public class StudentController {
	@Autowired
	StudentServInf studentServInf;
	
//1. Add
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return this.studentServInf.addStudent(student);
	}
	
//2.Update
	@PostMapping("/updateStudent/{id}")
	public Student updateStudent(@PathVariable("id") String id,@RequestBody Student newStudent) {
		return this.studentServInf.updateStudent(id, addStudent(newStudent));
	}

//3.Get
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable("id") String id) {
		return this.studentServInf.getStudentById(id);
	}
	
//4.Delete By Id
	@DeleteMapping("/delete/{id}")
	public String deleteStudentById(@PathVariable("id") String id) {
		return this.studentServInf.deleteStudentById(id);
	}
	
//5.Delete All
	@DeleteMapping("/deleteAll")
	public String deleteAllStudent() {
	return this.studentServInf.deleteAllStudent();
	}
	
	
}
