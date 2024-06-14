package com.example.HaulageManagementSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class HaulageItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer Id;
	Double length;
	Double width;
	Double height;
	Double volumetericWeight;
	Double weight;
	boolean fragile;

	@ManyToOne
	Haulage haulage;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	
	public Double getVolumetericWeight() {
		return volumetericWeight;
	}

	public void setVolumetericWeight(Double volumetericWeight) {
		this.volumetericWeight = volumetericWeight;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public boolean isFragile() {
		return fragile;
	}

	public void setFragile(boolean fragile) {
		this.fragile = fragile;
	}

	public Haulage getHaulage() {
		return haulage;
	}

	public void setHaulage(Haulage haulage) {
		this.haulage = haulage;
	}

}
