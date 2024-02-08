package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Citizens;
import com.example.demo.entity.VaccinationCenter;
import com.example.demo.service.ApplicationServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ApplicationController {
	
	@Autowired
	ApplicationServices applicationServices;
	
	
	@PostMapping("adminregister")
	public ModelAndView adminregister(Admin admin) {
		ModelAndView mv = new ModelAndView("index");
		if(!admin.getUsername().equals("") && !admin.getEmail().equals("") && !admin.getPassword().equals("")) {
			
			Admin subadmin =applicationServices.AddAdmin(admin);
			
			mv.addObject("message"," Successfully Register With Id "+subadmin.getId());
			return mv;
		}else {
			mv.addObject("message"," Fail To Register");
			return mv;
		}
	}
	@GetMapping("adminlogin")
	public ModelAndView adminlogin(@RequestParam("username") String username, @RequestParam("password") String password,HttpServletRequest request) {
		ModelAndView mv=null;
		HttpSession session = request.getSession();	
		if(!username.equals("") && !password.equals("")) {
			if(applicationServices.login(username, password)) {
				session.setAttribute("username", username);
				mv= new ModelAndView("adminindex");
				return mv;
			}else {
				mv= new ModelAndView("index");
				mv.addObject("message", "Invalid Username and Password");
				return mv;
			}
			
		}else {
			mv= new ModelAndView("index");
			mv.addObject("message", "Empty Username or password");
			return mv;
		}
	}
	
	//Admin LogOut
	@GetMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.setAttribute("username", null);
		session.invalidate();
		return "index";
	}
	
	
	//vaccinationCenter
	@GetMapping("/vaccinationCenter")
	public String vaccinationCenter(ModelMap map,HttpServletRequest request) {
		HttpSession se = request.getSession(true);
		if(se.getAttribute("username")== null){
			return "index";
		}
		
		List<VaccinationCenter> v_list = applicationServices.AllVaccinationCenter();
		map.addAttribute("Data", v_list);
		
		
		return "vaccinationCenter";
	}
	
	//Displaying The All the citizens
	@GetMapping("/citizens")
	public String View_All_Citizens(ModelMap map,HttpServletRequest request) {
		HttpSession se = request.getSession(true);
		if(se.getAttribute("username")== null){
			return "index";
		}
		List<Citizens> citizensList = applicationServices.AllCitizens();
		map.addAttribute("Data", citizensList);
		return "citizens";
	}
	
	//Adding vaccination centers
	
	@PostMapping("addnewcenter")
	public String addnewcenter(ModelMap map,VaccinationCenter vaccinationCenter, HttpServletRequest request) {
		HttpSession se = request.getSession(true);
		if(se.getAttribute("username")== null){
			return "index";
		}
		
		System.out.println(vaccinationCenter.getCity());
		
		if(!vaccinationCenter.getName().equals("") && !vaccinationCenter.getCity().equals("null")) {
			
			VaccinationCenter vc  = applicationServices.savecenter(vaccinationCenter);
			
			if(vc.getId()>0) {
				map.addAttribute("message", "Sucessfully Add Center With Id: "+vc.getId()+" <a href='vaccinationCenter'>VaccinationCenter</a>");
			}else {
				map.addAttribute("message", "Fail To Add Center");
			}
		}else {
			map.addAttribute("message", "Fail To Add Center Empty filds");	
		}
		return "add-new-center";
	}

	@PostMapping("editnewcenter")
	public String editnewcenter(ModelMap map, VaccinationCenter vaccinationCenter, HttpServletRequest request) {
		HttpSession se = request.getSession(true);
		if(se.getAttribute("username")== null){
			return "index";
		}
		if(!vaccinationCenter.getName().equals("") && !vaccinationCenter.getCity().equals("null")) {
			
			VaccinationCenter vc =applicationServices.editcenter(vaccinationCenter);
			
			if(vc.getId()>0) {
				map.addAttribute("message", "Sucessfully Updated Center <a href='vaccinationCenter'>VaccinationCenter</a>");
			}else {
				map.addAttribute("message", "Fail To Update Center");
			}
		}else {
			map.addAttribute("message", "Fail To Edit Center Empty filds");	
		}
		return "edit-vaccination-center";
	}
	
	@GetMapping("/delete-vaccination-center")
	public ModelAndView deletecenter(@RequestParam("id") long id, HttpServletRequest request) {
		HttpSession se = request.getSession(true);
		ModelAndView mv = new ModelAndView();
		if(se.getAttribute("username")== null){
			mv.setViewName("index");
			return mv;
		}else {
			mv.setViewName("vaccinationCenter");
			if(id>0) {
				applicationServices.delete(id);
			}
			return mv;
		}
	}
	
	@GetMapping("view-vaccination-center")
	public String gopageviewvaccination(ModelMap map,VaccinationCenter vaccinationCenter) {
		List<Citizens> citizenslist = applicationServices.findVaccinationCenter(vaccinationCenter);
		map.addAttribute("data", citizenslist);
		return"view-vaccination-center";
	}
	
	
	// Navigating to add citizens
	@GetMapping("Add-citizens")
	public String gotpageAdd_citizens(ModelMap map) {
		List<VaccinationCenter> list = applicationServices.getIDOfVacc();
		map.addAttribute("vacceinationcenterdata",list);
		return "Add-citizens";
	}
	
	//Adding Citizens
	@PostMapping("addcitizen")
	public String AddCitizens(ModelMap map, @RequestParam("name") String name, @RequestParam("city") String city,
			@RequestParam("doses") short doses, @RequestParam("vaccinationCenter_id") long vaccination_center_id) {

		if(!name.equals("")&&!city.equals("")&&doses !=0 && vaccination_center_id != 0) {
			Citizens citizens = applicationServices.SaveCitizens(name, city, doses, vaccination_center_id);
			map.addAttribute("message", "Added Successfully With Id: "+citizens.getId()+" Name"+citizens.getName()+" <a href='citizens'>Go To citizens</a>");
			return "Add-citizens";
		}else {
			map.addAttribute("message", "Fail TO Add Empty Fildes");
			return "Add-citizens";
		}
	}
	
	//Navegating to Citizens page
	@GetMapping("citizen-view")
	public String citizen_view(@RequestParam("id") long id, @RequestParam("name") String name, @RequestParam("city") String city, @RequestParam("doses") String doses){
		return "citizen-view";
	}
	
	//Navegating To citizen-edit
	@GetMapping("citizen-Edit")
	public String citizen_edit(ModelMap map) {
		List<VaccinationCenter> list = applicationServices.getIDOfVacc();
		map.addAttribute("vacceinationcenterdata", list);
		return "citizen-Edit";
	}
	
	//Editing Citizens
	@GetMapping("editcitizen")
	public ModelAndView Edit_citizens(ModelMap map, 
			@RequestParam("id") long id, 
			@RequestParam("name") String name, 
			@RequestParam("city") String city,
			@RequestParam("doses") short doses,
			@RequestParam("vaccination_center_id") long vaccination_center_id) {
		ModelAndView mv = new ModelAndView("citizen-Edit");
		if(id !=0 && !name.equals("") && !city.equals("") && doses != 0 && vaccination_center_id != 0) {
			Citizens cit = new Citizens();
			VaccinationCenter va = new VaccinationCenter(vaccination_center_id);
			
				cit.setId(id);
				cit.setName(name);
				cit.setCity(city); 
				cit.setDoses(doses);
				cit.setVaccinationCenter_Id(va);
			
			Citizens citizens = applicationServices.editCitizen(cit);
			map.addAttribute("message", "Edited Successfuly With Name "+citizens.getName()+" <a href='citizens'>citizens Page</a>");
		}else {
			map.addAttribute("message", "Fail To Edit <a href='citizens'>citizens Page</a>");
		}
		return mv;
	}
	@GetMapping("/citizen-delete")
	public ModelAndView deletecitizen(@RequestParam("id") long id) {
		ModelAndView mv = new ModelAndView("/citizens");
		applicationServices.deleteCitizen(id);
		return mv;
	}
}
