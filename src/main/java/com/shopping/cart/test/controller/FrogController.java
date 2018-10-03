package com.shopping.cart.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.model.Frog;

@RestController
public class FrogController {
	
	public FrogController() {
		System.out.println(")#@))##(*************###############**************#");
	}
	
	@RequestMapping(value="/frog",produces="application/json")
	public Frog findFrog(){
		 Frog frog=new Frog();
		 frog.setAge(10);
		 frog.setEmail("oepepe@gmail.com");
		 frog.setName("Jickky");
		return frog;
	}

}
