package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.dto.UserRequest;
import com.example.demo.exception.UserNotfoundException;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User saveUser(UserRequest userRequest) {
		User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		return repository.save(user);
	}
	
	public List<User> getAll(){
		return repository.findAll();
	}
	
	public User getUser(int id) throws UserNotfoundException {
		User user =  repository.findByUserId(id);
		
		if(user!=null) {
			return user;
		}else {
			throw new UserNotfoundException("user not found by id " +id);
		}
	}
}
