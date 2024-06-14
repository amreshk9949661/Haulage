package com.example.HaulageManagementSystem.Repository	;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HaulageManagementSystem.Entity.Consignment;

@Repository
public interface ConsignmentRepo extends JpaRepository<Consignment, Long>{

	
	
}
