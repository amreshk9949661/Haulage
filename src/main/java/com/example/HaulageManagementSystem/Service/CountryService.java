package com.example.HaulageManagementSystem.Service;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HaulageManagementSystem.Entity.*;
import com.example.HaulageManagementSystem.Repository.*;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	public List<Country> getAll() {

		return countryRepository.findAll();
	}

	public void saveCountry(Country country) {
		countryRepository.save(country);

	}

	public Country udpate(Long id) {

		return countryRepository.getOne(id);
	}

	public Country getOneObject(Long id) {
		
		return countryRepository.getById(id);
	}	
	public void delete(Long id) {
		Country country= getOneObject(id);
		countryRepository.delete(country);

	}

	public boolean existCountry( Country country) {

		boolean b = false;
		if (countryRepository.existCountry(country.getCountryName()) != null) {

			b = true;
		}
		return b;
	}
}
