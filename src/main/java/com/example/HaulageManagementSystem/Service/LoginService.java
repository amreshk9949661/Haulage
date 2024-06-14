package com.example.HaulageManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HaulageManagementSystem.Entity.LoginDetails;
import com.example.HaulageManagementSystem.Repository.*;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	public LoginDetails checkUserNamePassword(String user, String pass) {
		
		List<LoginDetails> list= loginRepository.checkUserNamePassword(user, pass);
		
		return list.size()>0?list.get(0):null;
	}
	
	public void addLoginDetails(LoginDetails loginDetails) {
		
		loginRepository.save(loginDetails);
	}
}
