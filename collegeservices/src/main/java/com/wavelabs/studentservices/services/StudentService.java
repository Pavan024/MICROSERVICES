package com.wavelabs.studentservices.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wavelabs.studentservices.Repositories.StudentRepository;
import com.wavelabs.studentservices.common.Constants;
import com.wavelabs.studentservices.entities.College;
import com.wavelabs.studentservices.entities.Student;
import com.wavelabs.studentservices.exceptions.NotFoundException;
import com.wavelabs.studentservices.mapper.StudentMapper;
import com.wavelabs.studentservices.request.StudentRequest;







@Service
public class StudentService {
	@Autowired
	CollegeService collegeService;
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	StudentRepository studentRepository;
	
	private static final Logger log = LoggerFactory.getLogger(StudentService.class);

	public Student createStudent(StudentRequest studentRequest, Long collegeId) {

		College college = collegeService.getCollege(collegeId);
		Student student = studentMapper.mapCreateStudentRequestToStudent(studentRequest, college);
		log.info("Creating College Account");
		Student createdStudent = studentRepository.save(student);
		log.info("Collge Student created");
		return createdStudent;
	}
	public Student getStudent(Long collegeId,Long studentId)
	{
		College college=collegeService.getCollege(collegeId);
		Optional<Student> student=studentRepository.findByIdAndCollege(studentId, college);
		if(!student.isPresent())
		{
			throw new NotFoundException(Constants.STUDENT_NOT_FOUND);
		}
		return student.get();
	}
	
	

	
}
