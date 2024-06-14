package com.example.HaulageManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HaulageManagementSystem.Entity.HaulageCenter;
import com.example.HaulageManagementSystem.Repository.HaulageCenterRepository;


@Service
public class HaulageCenterService {

	@Autowired
	HaulageCenterRepository haulageRepository;
	
	public List<HaulageCenter> getAll() {

		return haulageRepository.findAll();
	}

	
	public void saveCenter(HaulageCenter  haulagecenter) {
	haulageRepository.save(haulagecenter);
	
    }
 	public HaulageCenter update(Long id) {
		return haulageRepository.findById(id).get();
	
 	}
		
 	
}