package com.example.HaulageManagementSystem.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Haulage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String Booking_code;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private LocalDate booking_date;
	private String weight_unit;
	private String volume_unit;
	private String length_unit;
	private String distance_unit;
	private String haulage_mode;
	private String eWay_billNo;
	private String hazardous;
	private String explaination;
	private String consignment_type;
	private Integer no_of_Pieces;
	private String haulage_centre;
	private String description;
	private Double distance;
	private Double total_weight;
	private String haulage_service;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private LocalDate expected_DeliveryDate;
	private Double charges;
	private Double final_charges;
	private String Tax_type;
	private Double Tax_Percentage;
	private String Discount_type;
	private Double discount_in_amount;
	private Double discount_in_per;
	private String tracking_code;
	private String status;
	
	
	
	@OneToMany(mappedBy = "haulage", cascade = CascadeType.ALL, targetEntity = HaulageItem.class)
	List<HaulageItem> Haulageitem = new ArrayList<HaulageItem>();
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	HaulageCustomer customer;
	
	//Sender's info 
	private String Sender_Name;
	
    private String Sender_MobileNo;
	
	
	private String Sender_EmailId;
	
	private String Sender_AddressLine1;
	private String Sender_AddressLine2;
	private String Sender_City;
	private String Sender_Pincode;
	private String Sender_Landmark;
	
	@ManyToOne
    @JoinColumn(name = "sender_district_id")
	District sender_District;
	
	//Reciever's info
	private String reciever_Name;
	
	private String reciever_MobileNo;
	
	private String reciever_EmailId;
	private String reciever_AddressLine1;
	private String reciever_AddressLine2;
	private String reciever_City;
	private String reciever_Pincode;
	private String reciever_Landmark;
	
    @ManyToOne
    @JoinColumn(name = "receiver_district_id")
	District reciever_District;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBooking_code() {
		return Booking_code;
	}

	public void setBooking_code(String booking_code) {
		Booking_code = booking_code;
	}

	public LocalDate getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(LocalDate booking_date) {
		this.booking_date = booking_date;
	}

	public String getWeight_unit() {
		return weight_unit;
	}

	public void setWeight_unit(String weight_unit) {
		this.weight_unit = weight_unit;
	}

	public String getVolume_unit() {
		return volume_unit;
	}

	public void setVolume_unit(String volume_unit) {
		this.volume_unit = volume_unit;
	}

	public String getLength_unit() {
		return length_unit;
	}

	public void setLength_unit(String length_unit) {
		this.length_unit = length_unit;
	}

	public String getDistance_unit() {
		return distance_unit;
	}

	public void setDistance_unit(String distance_unit) {
		this.distance_unit = distance_unit;
	}

	public String getHaulage_mode() {
		return haulage_mode;
	}

	public void setHaulage_mode(String haulage_mode) {
		this.haulage_mode = haulage_mode;
	}

	public String geteWay_billNo() {
		return eWay_billNo;
	}

	public void seteWay_billNo(String eWay_billNo) {
		this.eWay_billNo = eWay_billNo;
	}

	public String getHazardous() {
		return hazardous;
	}

	public void setHazardous(String hazardous) {
		this.hazardous = hazardous;
	}

	public String getExplaination() {
		return explaination;
	}

	public void setExplaination(String explaination) {
		this.explaination = explaination;
	}

	public String getConsignment_type() {
		return consignment_type;
	}

	public void setConsignment_type(String consignment_type) {
		this.consignment_type = consignment_type;
	}

	public Integer getNo_of_Pieces() {
		return no_of_Pieces;
	}

	public void setNo_of_Pieces(Integer no_of_Pieces) {
		this.no_of_Pieces = no_of_Pieces;
	}

	public String getHaulage_centre() {
		return haulage_centre;
	}

	public void setHaulage_centre(String haulage_centre) {
		this.haulage_centre = haulage_centre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getTotal_weight() {
		return total_weight;
	}

	public void setTotal_weight(Double total_weight) {
		this.total_weight = total_weight;
	}

	public String getHaulage_service() {
		return haulage_service;
	}

	public void sethaulage_service(String haulage_service) {
		this.haulage_service = haulage_service;
	}

	public LocalDate getExpected_DeliveryDate() {
		return expected_DeliveryDate;
	}

	public void setExpected_DeliveryDate(LocalDate expected_DeliveryDate) {
		this.expected_DeliveryDate = expected_DeliveryDate;
	}

	public Double getCharges() {
		return charges;
	}

	public void setCharges(Double charges) {
		this.charges = charges;
	}

	public Double getFinal_charges() {
		return final_charges;
	}

	public void setFinal_charges(Double final_charges) {
		this.final_charges = final_charges;
	}

	public String getTax_type() {
		return Tax_type;
	}

	public void setTax_type(String tax_type) {
		Tax_type = tax_type;
	}

	public Double getTax_Percentage() {
		return Tax_Percentage;
	}

	public void setTax_Percentage(Double tax_Percentage) {
		Tax_Percentage = tax_Percentage;
	}

	public String getDiscount_type() {
		return Discount_type;
	}

	public void setDiscount_type(String discount_type) {
		Discount_type = discount_type;
	}

	public Double getDiscount_in_amount() {
		return discount_in_amount;
	}

	public void setDiscount_in_amount(Double discount_in_amount) {
		this.discount_in_amount = discount_in_amount;
	}

	public Double getDiscount_in_per() {
		return discount_in_per;
	}

	public void setDiscount_in_per(Double discount_in_per) {
		this.discount_in_per = discount_in_per;
	}

	public List<HaulageItem> getHaulageItem() {
		return Haulageitem;
	}

	public void setHaulageItem(List<HaulageItem> haulageItem) {
		Haulageitem = haulageItem;
	}

	public HaulageCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(HaulageCustomer customer) {
		this.customer = customer;
	}

	public String getSender_Name() {
		return Sender_Name;
	}

	public void setSender_Name(String sender_Name) {
		Sender_Name = sender_Name;
	}

	public String getSender_MobileNo() {
		return Sender_MobileNo;
	}

	public void setSender_MobileNo(String sender_MobileNo) {
		Sender_MobileNo = sender_MobileNo;
	}

	public String getSender_EmailId() {
		return Sender_EmailId;
	}

	public void setSender_EmailId(String sender_EmailId) {
		Sender_EmailId = sender_EmailId;
	}

	public String getSender_AddressLine1() {
		return Sender_AddressLine1;
	}

	public void setSender_AddressLne1(String sender_AddressLine1) {
		Sender_AddressLine1 = sender_AddressLine1;
	}

	public String getSender_AddressLine2() {
		return Sender_AddressLine2;
	}

	public void setSender_AddressLine2(String sender_AddressLine2) {
		Sender_AddressLine2 = sender_AddressLine2;
	}

	public String getSender_City() {
		return Sender_City;
	}

	public void setSender_City(String sender_City) {
		Sender_City = sender_City;
	}

	public String getSender_Pincode() {
		return Sender_Pincode;
	}

	public void setSender_Pincode(String sender_Pincode) {
		Sender_Pincode = sender_Pincode;
	}

	public District getSender_District() {
		return sender_District;
	}

	public void setSender_District(District sender_District) {
		this.sender_District = sender_District;
	}

	public String getReciever_Name() {
		return reciever_Name;
	}

	public void setReciever_Name(String reciever_Name) {
		this.reciever_Name = reciever_Name;
	}

	public String getReciever_MobileNo() {
		return reciever_MobileNo;
	}

	public void setReciever_MobileNo(String reciever_MobileNo) {
		this.reciever_MobileNo = reciever_MobileNo;
	}

	public String getReciever_EmailId() {
		return reciever_EmailId;
	}

	public void setReciever_EmailId(String reciever_EmailId) {
		this.reciever_EmailId = reciever_EmailId;
	}

	public String getReciever_AddressLine1() {
		return reciever_AddressLine1;
	}

	public void setReciever_AddressLine1(String reciever_AddressLne1) {
		this.reciever_AddressLine1 = reciever_AddressLne1;
	}

	public String getReciever_AddressLine2() {
		return reciever_AddressLine2;
	}

	public void setReciever_AddressLine2(String reciever_AddressLine2) {
		this.reciever_AddressLine2 = reciever_AddressLine2;
	}

	public String getReciever_City() {
		return reciever_City;
	}

	public void setReciever_City(String reciever_City) {
		this.reciever_City = reciever_City;
	}

	public String getReciever_Pincode() {
		return reciever_Pincode;
	}

	public void setReciever_Pincode(String reciever_Pincode) {
		this.reciever_Pincode = reciever_Pincode;
	}

	public District getReciever_District() {
		return reciever_District;
	}

	public void setReciever_District(District reciever_District) {
		this.reciever_District = reciever_District;
	}

	public List<HaulageItem> getHaulageitem() {
		return Haulageitem;
	}

	public void setHaulageitem(List<HaulageItem> haulageitem) {
		Haulageitem = haulageitem;
	}

	public String getSender_Landmark() {
		return Sender_Landmark;
	}

	public void setSender_Landmark(String sender_Landmark) {
		Sender_Landmark = sender_Landmark;
	}

	public String getReciever_Landmark() {
		return reciever_Landmark;
	}

	public void setReciever_Landmark(String reciever_Landmark) {
		this.reciever_Landmark = reciever_Landmark;
	}

	public String getTracking_code() {
		return tracking_code;
	}

	public void setTracking_code(String tracking_code) {
		this.tracking_code = tracking_code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setHaulage_service(String haulage_service) {
		this.haulage_service = haulage_service;
	}

	public void setSender_AddressLine1(String sender_AddressLine1) {
		Sender_AddressLine1 = sender_AddressLine1;
	}
	
	
}