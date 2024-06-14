package com.example.HaulageManagementSystem.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.courier.model.Registation;
//import com.courier.repository.RegistrationRepository;
import com.example.HaulageManagementSystem.Entity.Employee;
import com.example.HaulageManagementSystem.Entity.LoginDetails;
import com.example.HaulageManagementSystem.Repository.EmployeeRepository;
import com.example.HaulageManagementSystem.Repository.LoginRepository;



@Service
public class EmployeeService {

@Autowired 
EmployeeRepository employeerepo;


@Autowired
LoginRepository loginRepository;

public void saveEmployee(Employee employee) {
	 employeerepo.save(employee);	
	 
	 // 
	 LoginDetails reg= new LoginDetails();
	 reg.setEmailID(employee.getEmpemail());
	 reg.setUserName(employee.getEmpname());
	 reg.setPassword(employee.getEmpcontact());
	 loginRepository.save(reg);
}


public List<Employee> getAll() {

	return employeerepo.findAll();
}


public Employee update(Long id) {
	return employeerepo.findById(id).get();
	
}


public void delete(Long id) {
	 employeerepo.deleteById(id);
}



}
