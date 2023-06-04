package com.akhm.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.akhm.dao.StudentDAO;
import com.akhm.dao.model.StudentTl;
@Repository
public class StudentDAOImpl implements StudentDAO{
	@Autowired
	private HibernateTemplate ht;

	@Override
	
	public int insertStudentTl(StudentTl studentTl) {
		
		return (Integer)ht.save(studentTl);
	}

	@Override
	public StudentTl getStudent(Integer studentId) {
		
		return (StudentTl)ht.get(StudentTl.class, studentId);
	}

	@Override
	public List<StudentTl> getStudents() {
		
		return ht.loadAll(StudentTl.class);
	}

	@Override
	public void updateStudent(StudentTl studentTl) {
		ht.update(studentTl);
		
	}

	@Override
	public void deleteStudent(Integer studentId) {
		ht.get(StudentTl.class, studentId);
		
	}

}
