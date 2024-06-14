package com.example.HaulageManagementSystem.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HaulageManagementSystem.Entity.Haulage;
import com.example.HaulageManagementSystem.Repository.HaulageRepository;

import jakarta.validation.Valid;

@Service
public class HaulageService {


	
	@Autowired
    HaulageRepository HaulageRepository;

	@Autowired
	private HaulageRepository haulageRepository;

	private static final String ALPHANUMERIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	 public static String generateRandomString() {
	        StringBuilder randomString = new StringBuilder();
	        Random random = new Random();
	        int length = 10;
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(ALPHANUMERIC_CHARS.length());
	            char randomChar = ALPHANUMERIC_CHARS.charAt(index);
	            randomString.append(randomChar);
	        }
	        return randomString.toString();
	    }

	
	public List<Haulage> getAll() {
		return HaulageRepository.findAll();
	}

	public void saveObject(Haulage haulage) {

		HaulageRepository.save(haulage);
		
	}

	public Haulage getOneObject(Long id) {
		Optional<Haulage> optional = HaulageRepository.findById(id);
		return optional.get();
	}

	public void delete(Long id) {
		Haulage haulage = getOneObject(id);
		HaulageRepository.delete(haulage);

	}

	public void saveHaulage(@Valid Haulage haulage) {
		haulage.setTracking_code(generateRandomString());
		haulage.setStatus("Booked");
		
		haulageRepository.save(haulage);
	}

	public List<Haulage> getByBookingDate(LocalDate parsedDate) {
		
		return haulageRepository.findByBookingDate(parsedDate);
	}

	public List<Haulage> findByName(String name) {
		
//		haulageRepository.findByReciever_Name(name);
		return null;
	}

	
	public List<Haulage> getByClientName(String clientName){
		return haulageRepository.findBySender_Name(clientName);
	}

	public List<Haulage> getByClient_MobileNo(String clientMobileNo) {
		return haulageRepository.findBySender_MobileNo(clientMobileNo);
 
	}
	
	public List<Haulage> getByTrackingCode(String tracking_code) {
		return haulageRepository.findByTrackingCode(tracking_code);
 
	}

	public Haulage udpate(Long id) {
		
		return haulageRepository.getOne(id);
	}


	public Haulage getById(Long id) {
		return haulageRepository.findById(id).get();
	}
	
	public void updateStatus(Long id) {
		haulageRepository.updateCourierStatus(id);
	}
}
	



