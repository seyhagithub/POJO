package com.kshrd.repositories;

import java.util.ArrayList;

import com.kshrd.model.User;

public interface UserRepository {

	public ArrayList<User> findUsers();
	public boolean updateUser(User user);
	public boolean insertUser(User user);
	public boolean deleteUser(User user);
	
	
}
