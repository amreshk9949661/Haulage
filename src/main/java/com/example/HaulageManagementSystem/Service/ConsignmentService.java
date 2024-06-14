package com.example.HaulageManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HaulageManagementSystem.Entity.Consignment;
import com.example.HaulageManagementSystem.Repository.ConsignmentRepo;

@Service
public class ConsignmentService {

	@Autowired
	ConsignmentRepo consignmentRepo;
	
	public List<Consignment> getAll() {

		return consignmentRepo.findAll();
	}

	
	public void saveConsignment(Consignment  consignment) {
        consignmentRepo.save(consignment);
	
	}   
    	
	public Consignment updateConsignment(Long id) {
    
        return consignmentRepo.findById(id).get();	
    	
    }
    
	
}
