package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="vaccinationcenter")
public class VaccinationCenter {
	
	public VaccinationCenter() {
		
	}
	public VaccinationCenter(long id) {
		this.id=id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	@Column(name="center_name")
	private String name;
	
	@Column(name="center_city")
	private String city;
	
	@OneToMany(mappedBy = "vaccinationCenter_id", cascade = CascadeType.ALL)
	private List<Citizens> citizens;

	public List<Citizens> getCitizens() {
		return citizens;	
	}

	public void setCitizens(List<Citizens> citizens) {
		this.citizens = citizens;
	}

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
	
	
	
	
}
