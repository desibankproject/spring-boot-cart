package com.shopping.cart.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.shopping.cart.dao.UserRepository;
import com.shopping.cart.dao.entity.UserEntity;
import com.shopping.cart.model.UserForm;

@Service("UserService")
@Scope("singleton")
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String save(UserForm userForm){
			UserEntity userEntity=new UserEntity();
			BeanUtils.copyProperties(userForm, userEntity);
			userRepository.save(userEntity);
			return "success";
	}
	
}
