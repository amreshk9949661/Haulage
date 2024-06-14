package com.example.HaulageManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HaulageManagementSystem.Entity.*;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>{

	public List<District> getDistrictByStateId(Long id);
}
