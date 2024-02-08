package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Citizens;
import com.example.demo.entity.VaccinationCenter;
import com.example.demo.repo.AdminRepo;
import com.example.demo.repo.CitizensRepo;
import com.example.demo.repo.VaccinationCenterRepo;

@Service
public class ApplicationServices {
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	VaccinationCenterRepo vaccinationCenterRepo;
	
	@Autowired
	CitizensRepo citizensRepo;
	
	public Admin AddAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	
	public boolean login(String username, String password) {
		List<Admin> userlist= adminRepo.login(username, password);
		if(userlist.size() ==1) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<VaccinationCenter> AllVaccinationCenter(){
		List<VaccinationCenter> list = vaccinationCenterRepo.findAll();
		return list;
	}
	
	//view-vaccination-center service
	
	public void view_vaccination_center_data(long id) {
		
	}

	
	//getting all Citizens
	public List<Citizens> AllCitizens() {
		
		return citizensRepo.findAll();
	}
	
	
	//center Center
	public VaccinationCenter savecenter(VaccinationCenter vaccinationCenter) {
		VaccinationCenter vaccinationCenter1 = vaccinationCenterRepo.save(vaccinationCenter);
		return vaccinationCenter1;
	}

	
	//Center Edit
	public VaccinationCenter editcenter(VaccinationCenter vaccinationCenter) {
		
		VaccinationCenter exesting  = vaccinationCenterRepo.findById(vaccinationCenter.getId()).get();
		exesting.setName(vaccinationCenter.getName());
		exesting.setCity(vaccinationCenter.getCity());
		
		return vaccinationCenterRepo.save(exesting);
		
	}
	
	//center Deleting
	public void delete(long id) {
		vaccinationCenterRepo.deleteById(id);
	}

	public List<Citizens> findVaccinationCenter(VaccinationCenter vaccinationCenter) {
		List<Citizens> citizens = citizensRepo.CitizensOnVaccinationCenter(vaccinationCenter);
		return citizens;
	}

	public List<VaccinationCenter> getIDOfVacc() {
		List<VaccinationCenter> list = vaccinationCenterRepo.findAll();
		return list;
	}


	public Citizens SaveCitizens(String name, String city, short doses, long vaccination_center_id) {
		Citizens citizens = new Citizens();
		citizens.setName(name);
		citizens.setCity(city);
		citizens.setDoses(doses);
		VaccinationCenter VaccinationCenter = new VaccinationCenter(vaccination_center_id);
		citizens.setVaccinationCenter_Id(VaccinationCenter);
		
		citizens = citizensRepo.save(citizens);
		return citizens;
	}

	//Editing Citizens
	public Citizens editCitizen(Citizens cit) {
		Citizens q = citizensRepo.save(cit);
		return q;
	}

	public void deleteCitizen(long id) {
		citizensRepo.deleteById(id);
	}
	
}
