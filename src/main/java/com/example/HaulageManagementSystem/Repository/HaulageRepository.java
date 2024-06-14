package com.example.HaulageManagementSystem.Repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.HaulageManagementSystem.Entity.*;

import jakarta.transaction.Transactional;

@Repository
public interface HaulageRepository extends JpaRepository<Haulage, Long> {
	
	

	@Query("from Haulage AS hl where hl.booking_date=:parsedDate")
	List<Haulage> findByBookingDate(LocalDate parsedDate);

//	@Query("from Haulage AS hl where hl.sender_name=:name")
//	List<Haulage> findByReciever_Name(String name);
	
	@Query("from Haulage AS hl where hl.Sender_Name=:senderName")
	List<Haulage> findBySender_Name(String senderName);

	@Query("from Haulage AS hl where hl.Sender_MobileNo=:clientMobileNo")
	List<Haulage> findBySender_MobileNo(String clientMobileNo);

	
	@Query("from Haulage AS hl where hl.tracking_code=:tracking_code")
	List<Haulage> findByTrackingCode(String tracking_code);
	
//	@Query("from Haulage AS hl where hl.reciever_Name=:name")
//	List<Haulage> findByReciever_Name(String name);
//	
//	@Query("from Haulage AS hl where hl.reciever_Name=:name")
//	List<Haulage> findByReciever_Name(String name);
//	
//	@Query("from Haulage AS hl where hl.reciever_Name=:name")
//	List<Haulage> findByReciever_Name(String name);
// 

@Modifying
		@Transactional
	    @Query("UPDATE Haulage u SET u.status ='Cancelled' where u.id=:id")	
	    public void updateCourierStatus(Long id);
}
