package com.example.HaulageManagementSystem.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.HaulageManagementSystem.Entity.*;
import com.example.HaulageManagementSystem.Repository.*;

@Service
public class OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;
	
	public List<Organization> getAll() {
		return organizationRepository.findAll();
	}

	public void saveObject(Organization organization) {
		organizationRepository.save(organization);
	}

	public Organization getOneObject(Long id) {	
		Optional<Organization> optional =organizationRepository.findById(id);
		return optional.get();
	}	
	
	public void delete(Long id) {
		Organization organization= getOneObject(id);
		organizationRepository.delete(organization);

	}
}
