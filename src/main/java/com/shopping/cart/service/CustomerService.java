package com.shopping.cart.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.shopping.cart.controller.model.Customer;
import com.shopping.cart.dao.CustomerRespository;
import com.shopping.cart.dao.entity.CustomerEntity;

@Service("CustomerService")
@Scope("singleton")
public class CustomerService  implements ICustomerService{
	
	public CustomerService(){
		
	}
	
	@Autowired
	private CustomerRespository customerRespository;
	
	@Override
	public String saveCustomer(Customer customer){
		CustomerEntity entity=new CustomerEntity();
		BeanUtils.copyProperties(customer, entity);
		entity.setDoe(new Timestamp(new Date().getTime()));
		CustomerEntity customerEntity=customerRespository.save(entity);
		System.out.println(customerEntity);
		return "success";
	}
	
	@Override
	public List<Customer> findCustomersByGender(String gender){
		 List<CustomerEntity> customerEntityList=customerRespository.findByGender(gender);
		 List<Customer>  customers=new ArrayList<>();
		 for(CustomerEntity customerEntity:customerEntityList){
			 	Customer customer=new Customer();
			 	BeanUtils.copyProperties(customerEntity, customer);
			 	customers.add(customer);
		 }
		return customers;
	}
	
	

}
