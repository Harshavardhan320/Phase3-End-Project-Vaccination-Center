package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.VaccinationCenter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ApplicationController2 {

	@GetMapping("register")
	public String goPageRegister() {
		return "register";
	}
	@GetMapping("login")
	public String goPagelogin() {
		return "index";
	}	
	@GetMapping("index")
	public String goPagelogin1() {
		return "index";
	}	
	//nav to adding page for vaccination centers
	@GetMapping("add-new-center")
	public String addnewcenters() {
		return "add-new-center";
	}
	
	
	@GetMapping("adminindex")
	public String goPageAdmin(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession se = request.getSession(true);
		if(se.getAttribute("username")== null){
			return "index";
		}
		return "adminindex";
	}
					
	@GetMapping("edit-vaccination-center")
	public String gopageeditvaacinationcenter(VaccinationCenter vaccinationCenter) {
		return "edit-vaccination-center";
	}
}
