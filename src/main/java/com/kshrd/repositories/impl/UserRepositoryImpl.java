package com.kshrd.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kshrd.model.User;
import com.kshrd.repositories.UserRepository;

@Repository//("user1")
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	private DataSource dataSource;
	
	private Connection cnn;
	
	@Override
	public boolean deleteUser(User user){
		String sql = "DELETE FROM tbluser WHERE id = ?";
		try{
			cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			int rs = ps.executeUpdate();
			if(rs > 0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean insertUser(User user){
		String sql = "INSERT INTO TBLUSER (username, class_room) VALUES(?,?)";
		try{
			cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getClassRoom());
			int rs = ps.executeUpdate();
			if(rs > 0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public ArrayList<User> findUsers() {
		String sql = "SELECT "
				+ "			id, "
				+ "			username, "
				+ "			class_room "
				+ "	FROM "
				+ "		TBLUSER;";
		ArrayList<User> arr = new ArrayList<User>();
		User user = null;
		try{
			cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setClassRoom(rs.getString("class_room"));
				arr.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public boolean updateUser(User user) {
		String sql = "UPDATE "
				+ "		TBLUSER "
				+ "	SET  "
				+ "		username=? , "
				+ "		class_room=? "
				+ "	WHERE "
				+ "		id=?";
		try{
			cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getClassRoom());
			ps.setInt(3, user.getId());
			if(ps.executeUpdate() > 0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
