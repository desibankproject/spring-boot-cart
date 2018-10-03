package com.shopping.cart.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.cart.model.UserForm;
import com.shopping.cart.service.IUserService;

@Controller
public class HelloController {
	
	@Autowired
	@Qualifier("UserService")
	private IUserService userService;
	
	@RequestMapping("/")
	public String welcome(){
		return "index";
	}
	
	@RequestMapping(value="/welcome",method=RequestMethod.POST)
	public String welcome(String name,String email,Model model){
		UserForm userForm=new UserForm();
		userForm.setEmail(email);
		userForm.setName(name);
		userService.save(userForm);
		model.addAttribute("name"," Hello Mr. "+name) ;
		return "hello";
	}
}
