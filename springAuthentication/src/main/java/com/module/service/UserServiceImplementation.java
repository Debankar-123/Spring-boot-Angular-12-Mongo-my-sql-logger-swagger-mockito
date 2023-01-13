package com.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.model.User;
import com.module.repository.UserRepository;
@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public User addUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public String getUsertype(String email, String password) {
		
		User u=userRepository.findByEmailAndPassword(email, password);
		return u.getRole();
	}

	@Override
	public User updateUser(User user) {
//		User u=userRepository.findById(user.getUserId()).get();
//		u.setUserId(user.getUserId());
//		u.setUserName(user.getUserName());
//		u.setEmail(user.getEmail());
//		u.setPassword(user.getPassword());
//		u.setRole(user.getRole());
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUserByRole(String role) {
		
		return userRepository.getAllByRole(role);
	}
}
