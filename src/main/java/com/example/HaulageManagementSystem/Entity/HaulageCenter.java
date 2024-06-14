package com.example.HaulageManagementSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class HaulageCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String Name;
	private String Manager;
	private String Phone;
	private String Email;
	private String Designation;
	private String Addressl1;
	private String Addressl2;
	private String city;
	private String Pincode;
	private String Landmark;
	
	@ManyToOne
    @JoinColumn(name = "Center_district_id")
	District centerDistrict;

	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getManager() {
		return Manager;
	}


	public void setManager(String manager) {
		Manager = manager;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getDesignation() {
		return Designation;
	}


	public void setDesignation(String designation) {
		Designation = designation;
	}


	public String getAddressl1() {
		return Addressl1;
	}


	public void setAddressl1(String addressl1) {
		Addressl1 = addressl1;
	}


	public String getAddressl2() {
		return Addressl2;
	}


	public void setAddressl2(String addressl2) {
		Addressl2 = addressl2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPincode() {
		return Pincode;
	}


	public void setPincode(String pincode) {
		Pincode = pincode;
	}


	public String getLandmark() {
		return Landmark;
	}


	public void setLandmark(String landmark) {
		Landmark = landmark;
	}


	public District getCenterDistrict() {
		return centerDistrict;
	}


	public void setCenterDistrict(District centerDistrict) {
		this.centerDistrict = centerDistrict;
	}
	
	
	
}
