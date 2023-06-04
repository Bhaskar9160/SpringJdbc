package com.akhm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.akhm.dao.StudentDAO;
import com.akhm.dao.model.StudentTl;
import com.akhm.service.StudentService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public Integer insertStudentTl(StudentTl studentTl) {
		log.info("{}-StudentServiceImpl insertStudentTl()method  user details");
		return studentDAO.insertStudentTl(studentTl);
	}

	@Override
	public StudentTl getStudent(Integer studentId) {
		log.info("{}-StudentServiceImpl getStudent()method  user details");
		return studentDAO.getStudent(studentId);
	}

	@Override
	public List<StudentTl> getStudents() {
		log.info("{}-StudentServiceImpl getStudents()method  user details");

		return studentDAO.getStudents();
	}

	@Override
	public void updateStudent(StudentTl studentTl) {
		log.info("{}-StudentServiceImpl updateStudent()method  user details");

		studentDAO.updateStudent(studentTl);
		
	}

	@Override
	public void deleteStudent(Integer studentId) {
		log.info("{}-StudentServiceImpl deleteStudent()method  user details");

		studentDAO.deleteStudent(studentId);
		
	}

}
