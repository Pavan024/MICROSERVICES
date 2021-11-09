package com.wavelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wavelabs.entity.Center;


@Repository
public interface CenterRepository extends JpaRepository<Center, Long>{

}
