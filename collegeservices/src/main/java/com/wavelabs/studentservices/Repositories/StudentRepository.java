package com.wavelabs.studentservices.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wavelabs.studentservices.entities.College;
import com.wavelabs.studentservices.entities.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByIdAndCollege(Long studentId, College college);	
	
}
