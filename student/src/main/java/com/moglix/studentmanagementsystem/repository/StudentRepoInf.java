package com.moglix.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moglix.studentmanagementsystem.dto.Student;

@Repository
public interface StudentRepoInf extends JpaRepository<Student, String>{

}
