package com.moglix.studentmanagementsystem.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="student_tbl")
public class Student {
			
	//Student fields
	@Id
	private String studentId;
	private String studentName;
	private String emailId;
	private String mobNo;
	private String address;
	private String studentClass;
	
	//Parameterized Constructor
	public Student(String studentId, String studentName, String emailId, String mobNo, String address,
			String studentClass) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.emailId = emailId;
		this.mobNo = mobNo;
		this.address = address;
		this.studentClass = studentClass;
	}

	//Explicit Default Constructor
	public Student() {
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", emailId=" + emailId + ", mobNo="
				+ mobNo + ", address=" + address + ", studentClass=" + studentClass + "]";
	}
	
	
	
	
}
