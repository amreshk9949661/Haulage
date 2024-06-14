package com.example.HaulageManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HaulageManagementSystem.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {



}
