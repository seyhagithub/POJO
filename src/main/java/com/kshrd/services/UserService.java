package com.kshrd.services;

import java.util.ArrayList;

import com.kshrd.model.User;

public interface UserService {
	
	public ArrayList<User> findUsers();
	public boolean updateUser(User user);
	public boolean insertUser(User user);
	public boolean deleteUser(User user);
}
