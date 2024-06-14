package com.example.HaulageManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HaulageManagementSystem.Entity.HService;
import com.example.HaulageManagementSystem.Repository.ServiceHaulageRepository;

import jakarta.validation.Valid;

@Service
public class ServiceHaulageService {

	@Autowired
	ServiceHaulageRepository sRepository;

	public List<HService> getAll() {
		return sRepository.findAll();

	}

	public void saveDetails(@Valid HService haulage) {
		sRepository.save(haulage);
	}
	
	public HService update(Long id) {
		return sRepository.findById(id).orElse(null);
		
	}

	public HService getById(Long id) {
		return sRepository.findById(id).get();
	}

}
