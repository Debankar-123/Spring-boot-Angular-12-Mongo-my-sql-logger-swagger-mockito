package com.module.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.module.model.User;
import com.module.service.UserServiceImplementation;

@RestController
@RequestMapping(value="/user")
@CrossOrigin(origins = "*")
public class UserController {
	private Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserServiceImplementation userServiceImplementation;
	
	@PostMapping("/register")
	public User addUsers(@RequestBody User user) {
		logger.info("Register user accessed");
		return userServiceImplementation.addUser(user);
	}
	@GetMapping("/findById/{id}")
	public User getUserById(@PathVariable int id) {
		logger.info("findByUserId accessed");
		return userServiceImplementation.getUserById(id);
	}
	@GetMapping("/findbyEmailAndPassword/{email}/{password}")
	public String getUsertype(@PathVariable String email,@PathVariable String password) {
		logger.info("findbyEmailAndPassword(User Login) accessed");
		return userServiceImplementation.getUsertype(email, password);
	}
	@GetMapping("/getByRole/{role}")
	public List<User> getAlluserByRole(@PathVariable String role) {
		logger.info("getAlluserByRole accessed");
		if(role.equalsIgnoreCase("manager"))
		return userServiceImplementation.getAllUserByRole(role);
		else
		return null;
	}
	@PutMapping("/update")
	public User updateUserById(@RequestBody User user) {
		logger.info("update user accessed");
		return userServiceImplementation.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable int id) {
		logger.info("deleteUser using userId accessed");
		userServiceImplementation.deleteUserById(id);
	}
}
