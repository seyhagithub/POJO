package com.kshrd.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.kshrd.model.User;
import com.kshrd.services.UserService;

@Controller
public class MyController {

	// call service layer
	// Field Injection 
	@Autowired
	private UserService userService;
	
	@RequestMapping("/get")
	@ResponseBody
	public ArrayList<User> findUsers(){
		return userService.findUsers();
	}
	
	@RequestMapping("/getAll")
	public String getAll(ModelMap model){
		model.addAttribute("students",userService.findUsers());
		return "homepage";
	}
	
	@RequestMapping("/update/{id}")
	@ResponseBody
	public String getById(int id){
		System.out.println(id);
		return "update";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
		User user = new User();
		user.setId(id);
		userService.deleteUser(user);
		return "redirect:/getAll";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public boolean updateUser(){
		User user = new User();
		user.setId(1);
		user.setUsername("POJO");
		user.setClassRoom("SR9999");
		return userService.updateUser(user);
	}
	
	@RequestMapping(value="register" , method = RequestMethod.GET)
	public String registerPage(ModelMap model){
		model.addAttribute("message","Register");
		model.addAttribute("user" , new User());
		return "registerform";
	}

	@RequestMapping(value="register" , method = RequestMethod.POST)
	public String register(User user, ModelMap model){
		model.addAttribute("message","Home Page");
		model.addAttribute("user", user);
		userService.insertUser(user);
		return "redirect:/getAll";
	}
	
	
}
