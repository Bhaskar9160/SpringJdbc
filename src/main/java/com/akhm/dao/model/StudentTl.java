package com.akhm.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "STUDENT_TL")
@Data
public class StudentTl {
	@Id
	@Column(name="STUDENT_ID")
	private int studentId;
	@Column(name = "STUDENT_NAME")
	private String studentName;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "PASSWORD")
	private String password;

	
	

}
