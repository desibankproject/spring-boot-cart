package com.shopping.cart.service;

import java.util.List;

import com.shopping.cart.controller.model.Customer;

/**
 * 
 * @author VC1
 *
 */
public interface ICustomerService {
	public abstract String saveCustomer(Customer customer);
	public abstract List<Customer> findCustomersByGender(String gender);
}
