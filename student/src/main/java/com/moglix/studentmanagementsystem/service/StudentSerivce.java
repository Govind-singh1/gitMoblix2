package com.moglix.studentmanagementsystem.service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moglix.studentmanagementsystem.dto.Student;
import com.moglix.studentmanagementsystem.repository.StudentRepoInf;

@Service
public class StudentSerivce implements StudentServInf {
	
	@Autowired
	StudentRepoInf studentRepoInf;

//1.Add
	@Override
	public Student addStudent(Student student) {
		if(isValidNum(student) & isValidEmail(student)) {
			Student student2=studentRepoInf.save(student);
			return student2;
		}	
		else
		return null;
	}

//2.Update
	@Override
	public Student updateStudent(String id, Student student) {
		if(getStudentById(id)!=null) {
				return addStudent(student);
		}else
		return null;
	}
//3. Get
	@Override
	public Student getStudentById(String id) {
		Optional<Student> optional =studentRepoInf.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
		return null;
	}
//4.Delete By Id
	@Override
	public String deleteStudentById(String id) {
		try {
			studentRepoInf.deleteById(id);
			return "Delete Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Delete Fail";
		}
	}
//5.Delete All
	@Override
	public String deleteAllStudent() {
		studentRepoInf.deleteAll();
		return "success";
	}
	
//6.Validate Number.
	public boolean isValidNum(Student student) {
		String mobNo= student.getMobNo();
		Pattern p =Pattern.compile("[789]{1}[0-9]{9}");
		Matcher m = p.matcher(mobNo);
		
		return (m.matches());
	}
	
//7.Validate Email
	public boolean isValidEmail(Student student) {
		String email=student.getEmailId();
		String regex = "^[a-z0-9+_.-]+@[a-z0-9.]$";
//		 String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
//                 "[a-zA-Z0-9_+&*-]+)*@" +
//                 "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
//                 "A-Z]{2,7}$";
                   
		 Pattern p1 = Pattern.compile(regex);
		 Matcher m1 = p1.matcher(email);
		 return (m1.matches());
	}

}
