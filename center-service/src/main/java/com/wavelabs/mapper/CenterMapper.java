package com.wavelabs.mapper;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.wavelabs.entity.Center;
import com.wavelabs.response.ExamResponse;





@Service
public class CenterMapper {

	public Center mapExamResponseToCenter(ExamResponse examResponse, String examCenterName) {
	return new Center(examResponse.getStudentNumber(),examResponse.getStudentName() , 
			examCenterName,examResponse.getStudentName(),examResponse.getExamCenter(),Instant.now());	
}
	
}
