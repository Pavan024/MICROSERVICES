package com.wavelabs.studentservices.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wavelabs.studentservices.Repositories.CollegeRepository;
import com.wavelabs.studentservices.common.Constants;
import com.wavelabs.studentservices.entities.College;
import com.wavelabs.studentservices.exceptions.NotFoundException;
import com.wavelabs.studentservices.request.CollegeRequest;




@Service
public class CollegeService {
	@Autowired
	CollegeRepository collegeRepository;
	
	private static final Logger log = LoggerFactory.getLogger(CollegeService.class);
	
	
	public College createCollege(CollegeRequest collegeRequest)
	{
		ModelMapper modelMapper = new ModelMapper();
		College college = modelMapper.map(collegeRequest, College.class);
		log.info("Creating College");
		College createdCollege = collegeRepository.save(college);
		log.info("College created");
		return createdCollege;
	}
	public College getCollege(Long id) {
		Optional<College> college = collegeRepository.findById(id);
		if (!college.isPresent()) {
			throw new NotFoundException(Constants.COLLEGE_NOT_FOUND);
		}
		return college.get();
	}
	
	
	
}
