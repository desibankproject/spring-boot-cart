package com.shopping.cart.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.shopping.cart.dao.entity.UserEntity;

/**
 * @author nagendra
 * 
 * spring data we have to design only interface since implementation will be given by spring data
 *
 */
@Transactional
public interface UserRepository extends CrudRepository<UserEntity, Integer>{

	public  UserEntity findByEmail(String email);
	public  UserEntity findByName(String name);
	
}
