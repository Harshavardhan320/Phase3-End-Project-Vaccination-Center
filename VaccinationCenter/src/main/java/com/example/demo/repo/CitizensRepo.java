package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Citizens;
import com.example.demo.entity.VaccinationCenter;

@Repository
public interface CitizensRepo extends JpaRepository<Citizens, Long> {
	
	@Query("from Citizens where vaccinationCenter_id=?1")
	List<Citizens> CitizensOnVaccinationCenter(VaccinationCenter vaccinationCenter);

}
