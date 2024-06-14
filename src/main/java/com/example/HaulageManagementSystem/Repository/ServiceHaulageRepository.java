package com.example.HaulageManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HaulageManagementSystem.Entity.HService;

@Repository
public interface ServiceHaulageRepository extends JpaRepository<HService, Long> {

}
