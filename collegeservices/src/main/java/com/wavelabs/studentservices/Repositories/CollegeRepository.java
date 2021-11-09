package com.wavelabs.studentservices.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wavelabs.studentservices.entities.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {
	Optional<College> findById(Long collegeId);
}
