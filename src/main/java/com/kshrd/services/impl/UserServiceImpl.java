package com.kshrd.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.model.User;
import com.kshrd.repositories.UserRepository;
import com.kshrd.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	// call repository layer
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ArrayList<User> findUsers() {
		// TODO Auto-generated method stub
		return userRepository.findUsers();
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.updateUser(user);
	}
	
	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.insertUser(user);
	}
	
	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.deleteUser(user);
	}

}
