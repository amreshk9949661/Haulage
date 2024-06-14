package com.example.HaulageManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HaulageManagementSystem.Entity.HaulageCenter;

@Repository
public interface HaulageCenterRepository extends JpaRepository<HaulageCenter, Long>{

	
	
}
