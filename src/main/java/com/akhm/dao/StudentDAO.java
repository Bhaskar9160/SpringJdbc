package com.akhm.dao;

import java.util.List;

import com.akhm.dao.model.StudentTl;

public interface StudentDAO {
	public int insertStudentTl(StudentTl studentTl);
	public StudentTl getStudent(Integer studentId);
	public List<StudentTl> getStudents();
	public void updateStudent(StudentTl studentTl);
	public void deleteStudent(Integer studentId);

}
