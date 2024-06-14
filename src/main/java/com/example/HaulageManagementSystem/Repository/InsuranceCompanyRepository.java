package com.example.HaulageManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HaulageManagementSystem.Entity.Employee;
import com.example.HaulageManagementSystem.Entity.InsuranceCompany;

public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Long> {



}
