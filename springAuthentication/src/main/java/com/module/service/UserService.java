package com.module.service;

import java.util.List;

import com.module.model.User;

public interface UserService {
	public User addUser(User user);
	public User getUserById(int id);
	public String getUsertype(String email,String password);
	public User updateUser(User user);
	public void deleteUserById(int id);
	public List<User> getAllUserByRole(String role);
	
}
