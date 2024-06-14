package com.example.HaulageManagementSystem.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String empname;

	private String empemail;

	public String getEmpaddress() {
		return empaddress;
	}

	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}

	public String getEmpdob() {
		return empdob;
	}

	public void setEmpdob(String empdob) {
		this.empdob = empdob;
	}

	public String getEmpzipcode() {
		return empzipcode;
	}

	public void setEmpzipcode(String empzipcode) {
		this.empzipcode = empzipcode;
	}

	public String getEmptype() {
		return emptype;
	}

	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}

	private String designation;

	private String empcontact;
	private String empaddress;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private String empdob;
	
	private String empzipcode;
	private String emptype;
	private String emp_country;
	private String emp_state;
	private String emp_city;
	private String emp_district;

	public String getEmp_district() {
		return emp_district;
	}

	public void setEmp_district(String emp_district) {
		this.emp_district = emp_district;
	}

	public String getEmp_country() {
		return emp_country;
	}

	public void setEmp_country(String emp_country) {
		this.emp_country = emp_country;
	}

	public String getEmp_state() {
		return emp_state;
	}

	public void setEmp_state(String emp_state) {
		this.emp_state = emp_state;
	}

	public String getEmp_city() {
		return emp_city;
	}

	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}

	public Employee() {
		//default constructor
	}
	
	public Employee(Long id, String empname, String empemail, String designation, String empcontact, String empaddress, String empdob, String empzipcode, String emptype, String empstate) {
		super();
		this.id = id;
		this.empname = empname;
		this.empemail = empemail;
		this.designation = designation;
		this.empcontact = empcontact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpemail() {
		return empemail;
	}

	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmpcontact() {
		return empcontact;
	}

	public void setEmpcontact(String empcontact) {
		this.empcontact = empcontact;
	}

	
}