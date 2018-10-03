package com.shopping.cart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.controller.message.ApplicationMessageVO;
import com.shopping.cart.controller.model.FactorialVO;

@RestController
public class FactorialController {
	
	@CrossOrigin(origins = "http://localhost:4200")
	//RequestMapping(value="/upload-fact",method=RequestMethod.POST)
	@PostMapping("/upload-fact")
	//{"num":5,"result:120"}
	public ApplicationMessageVO  uploadFactData(@RequestBody FactorialVO factorialVO){
			System.out.println("@)@)@))@");
			//Here we can write code to persist data into the database
			System.out.println("_______________@#((((((((((((((((((((((((*&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			System.out.println(factorialVO);
			System.out.println(factorialVO);
			System.out.println("_______________@#((((((((((((((((((((((((*&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			ApplicationMessageVO applicationMessageVO=new ApplicationMessageVO();
			applicationMessageVO.setStatus("success");
			applicationMessageVO.setMessage("factorial detail has been uploaded successfully.... "+factorialVO);
			return applicationMessageVO;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	//RequestMapping(value="/upload-fact",method=RequestMethod.POST)
	@GetMapping("/factresults")
	//{"num":5,"result:120"}
	public List<FactorialVO>  factResults(){
		List<FactorialVO> factorialVOs=new ArrayList<FactorialVO>(); // type inference
		FactorialVO factorialVO1=new FactorialVO(1,1);
		FactorialVO factorialVO2=new FactorialVO(2,2);
		FactorialVO factorialVO3=new FactorialVO(3,6);
		FactorialVO factorialVO4=new FactorialVO(4,24);
		FactorialVO factorialVO5=new FactorialVO(5,120);
		factorialVOs.add(factorialVO5);
		factorialVOs.add(factorialVO4);
		factorialVOs.add(factorialVO3);
		factorialVOs.add(factorialVO2);
		factorialVOs.add(factorialVO1);
		return factorialVOs;
	}

}
