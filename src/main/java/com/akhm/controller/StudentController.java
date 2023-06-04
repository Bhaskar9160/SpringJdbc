package com.akhm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akhm.dao.model.StudentTl;
import com.akhm.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student/save")
	public ResponseEntity<Integer> insertStudentTl(@RequestBody StudentTl studentTl){
		log.info("{}-StudentController...insertStudentTl() method Started");
		try {
			log.info("{}-StudentController insertStudentTl()method get user details");

			return new ResponseEntity<Integer>(studentService.insertStudentTl(studentTl),HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("{}-StudentController insertStudentTl() method error message is:"+e.getMessage());
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/student/get/{studentId}")
	@Transactional
	public ResponseEntity<StudentTl>getStudent(@PathVariable ("studentId") Integer studentId){
		log.info("{}-StudentController...getStudent() method Started");
		try {
			log.info("{}-StudentController getStudent()method get user details");
			return new ResponseEntity<StudentTl>(studentService.getStudent(studentId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("{}-StudentController getStudent() method error message is:"+e.getMessage());
			return new ResponseEntity<StudentTl>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/student/getstudents")
	public ResponseEntity<List<StudentTl>> getStudents(){
		log.info("{}-StudentController...getStudents() method Started");
		try {
			log.info("{}-StudentController getStudents()method get user details");
			return new ResponseEntity<List<StudentTl>>(studentService.getStudents(),HttpStatus.OK);
		} catch (Exception e) {
			log.error("{}-StudentController getStudents() method error message is:"+e.getMessage());
			return new ResponseEntity<List<StudentTl>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/student/update")
	public ResponseEntity<Void> updateStudent(@RequestBody StudentTl studentTl){
		log.info("{}-StudentController...updateStudent() method Started");
		try {
			log.info("{}-StudentController updateStudent()method get user details");
			studentService.updateStudent(studentTl);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("{}-StudentController updateStudent() method error message is:"+e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/student/delete/")
	@Transactional
	public ResponseEntity<Void> deleteStudent(@PathVariable ("studentId") Integer studentId){
		log.info("{}-StudentController...delectStudent() method Started");
		try {
			log.info("{}-StudentController delectStudent()method get user details");
			studentService.deleteStudent(studentId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("{}-StudentController delectStudent() method error message is:"+e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
