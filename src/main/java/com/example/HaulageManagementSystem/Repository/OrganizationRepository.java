package com.example.HaulageManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HaulageManagementSystem.Entity.*;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{

}
