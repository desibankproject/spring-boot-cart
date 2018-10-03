package com.shopping.cart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.shopping.cart.dao.entity.CustomerEntity;



/**
 * 
 * @author VC1
 * this is our interface no need to write implementation
 * implementation will be provided by the spring data
 *
 */
@Transactional

public interface CustomerRespository   extends CrudRepository<CustomerEntity, Integer>{
	
	public  List<CustomerEntity> findByGender(String gender);
}
