package com.sample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.vo.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate template;
	
	public void insertUser(User user) {
		String sql = "insert into sample_users values(?, ?, ?, ?, ?)";
		template.update(sql, user.getId(), user.getPassword(), user.getName(), user.getTel(), user.getEmail());
	}
	
	public void deleteUser(String id) {
		
	}
	
	public void updateUser(User user) {
		
	}
	
	public List<User> getAllUser() {
		return null;
	}
	
	public User getUserById(String id) {
		return null;
	}
}
