package com.wavelabs.studentservices.mapper;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.wavelabs.studentservices.entities.College;
import com.wavelabs.studentservices.entities.Status;
import com.wavelabs.studentservices.entities.Student;
import com.wavelabs.studentservices.request.StudentRequest;

@Service
public class StudentMapper {
	
	public Student mapCreateStudentRequestToStudent(StudentRequest studentRequest, College college) {
		return new Student(generateStudentNumber(college.getCode(),studentRequest.getExamcenterId()) , 
				studentRequest.getType(),Status.valueOf(studentRequest.getStatus()),
				studentRequest.getExamCenter(),		studentRequest.getStudentName(),studentRequest.getExamcenterId(),studentRequest.getCollegeCode(),college);
	}
	private String generateStudentNumber(String collegeCode, String examcenterId)
	{
		return (String.valueOf(Math.abs(collegeCode.hashCode())) + String.valueOf(Math.abs(examcenterId.hashCode()))
		+ String.valueOf(Instant.now().getEpochSecond())).substring(0, 15);
	}
	
	
	
	
}
