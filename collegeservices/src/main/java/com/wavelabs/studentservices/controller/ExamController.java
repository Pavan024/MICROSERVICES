package com.wavelabs.studentservices.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wavelabs.studentservices.entities.Student;
import com.wavelabs.studentservices.request.ExamRequest;
import com.wavelabs.studentservices.response.ExamResponse;
import com.wavelabs.studentservices.services.ExamService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/collegeService/v1/exams")
@Api(value = "Exam Management", tags = { "Exam Management" })
@Validated
public class ExamController {
	@Autowired
	ExamService examService;
	
	@ApiOperation(value = "Adding center to College student")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ExamRequest.class, message = "Center added Successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = String.class, message = "Invalid parameters") })
	@PostMapping(value = "/adding", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<ExamResponse> adding(@Valid @RequestBody ExamRequest examRequest) {
	
		Student student = examService.adding(examRequest);
		ModelMapper modelMapper = new ModelMapper();
		ExamResponse examResponse = modelMapper.map(student, ExamResponse.class);
		examResponse.setCollegeName(student.getCollege().getName());
		return ResponseEntity.status(HttpStatus.OK).body(examResponse);
}
}