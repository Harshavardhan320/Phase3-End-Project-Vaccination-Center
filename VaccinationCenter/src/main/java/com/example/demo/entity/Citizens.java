package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="citizen")
public class Citizens {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="city")
	private String city;
	
	@Column(name="doses")
	private short doses;
	
	 @ManyToOne 
	 @JoinColumn(name="vaccination_center_id")
	 private VaccinationCenter vaccinationCenter_id;
	 
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public short getDoses() {
		return doses;
	}


	public void setDoses(short doses) {
		this.doses = doses;
	}
	
	public VaccinationCenter getVaccinationCenter_Id() { return vaccinationCenter_id; }
	  
	  
	public void setVaccinationCenter_Id(VaccinationCenter vaccinationCenter) {
		this.vaccinationCenter_id = vaccinationCenter; 
	}


	@Override
	public String toString() {
		return "Citizens [id=" + id + ", name=" + name + ", city=" + city + ", doses=" + doses
				+ ", vaccinationCenter_id=" + vaccinationCenter_id + "]";
	}


	


	
	 
}
