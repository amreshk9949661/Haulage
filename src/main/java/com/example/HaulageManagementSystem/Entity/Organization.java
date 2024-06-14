package com.example.HaulageManagementSystem.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Required Field")
	private String organizationName;
	
	@NotBlank(message = "Required Field")
	private String ownerName;
	
	@NotNull(message = "Required Field")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate establishmentDate;
	
	@NotEmpty(message = "Required Field")
	private String ownershipType;
	
	@NotNull(message = "Required Field")
	private Boolean gstApplicable;
	
	@NotNull(message = "Required Field")
	private Double annualRevenue;
	
	@NotEmpty(message = "Required Field")
	private String contactNo;
	
	private String branchName;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public LocalDate getEstablishmentDate() {
		return establishmentDate;
	}

	public void setEstablishmentDate(LocalDate establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	public String getOwnershipType() {
		return ownershipType;
	}

	public void setOwnershipType(String ownershipType) {
		this.ownershipType = ownershipType;
	}

	public Boolean getGstApplicable() {
		return gstApplicable;
	}

	public void setGstApplicable(Boolean gstApplicable) {
		this.gstApplicable = gstApplicable;
	}

	public Double getAnnualRevenue() {
		return annualRevenue;
	}

	public void setAnnualRevenue(Double annualRevenue) {
		this.annualRevenue = annualRevenue;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}