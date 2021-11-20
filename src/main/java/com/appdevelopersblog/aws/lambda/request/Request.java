package com.appdevelopersblog.aws.lambda.Request;

import com.appdevelopersblog.aws.lambda.model.Student;

public class Request {
	private String httpMethod;
	
	private int id;

	private Student student;

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


}
