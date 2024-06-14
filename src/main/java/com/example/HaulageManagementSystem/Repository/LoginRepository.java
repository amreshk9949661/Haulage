package com.example.HaulageManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.HaulageManagementSystem.Entity.LoginDetails;

@Repository
public interface LoginRepository extends JpaRepository<LoginDetails, Long>{
	
	@Query("FROM LoginDetails as LD WHERE LD.userName=:user AND LD.password=:pass")
	List<LoginDetails> checkUserNamePassword(String user, String pass);
}

