package com.module;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.module.model.User;
import com.module.repository.UserRepository;
import com.module.service.UserServiceImplementation;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpringAuthenticationApplicationTests {
	
	@Mock
	private UserRepository userRepository;
	@InjectMocks
	private UserServiceImplementation userServiceImp;
	
	User user1=new User(101,"prashanth","prashanth@gmail.com","prash123","Chairman");
	User user2=new User(102,"Ramesh","ramesh@gmail.com","ram098","Manager");
	
	@Test
	public void addUserTest() {
		Mockito.when(userRepository.save(user1)).thenReturn(user1);
		assertEquals(user1, userServiceImp.addUser(user1));
	}
	
	@Test
	public void getUserByIdTest() {
		Mockito.when(userRepository.findById(user1.getUserId())).thenReturn(Optional.of(user1));
		assertEquals(user1, userServiceImp.getUserById(user1.getUserId()));
	}
	
	@Test
	public void getUsertypeTest() {
		User user3=new User(103,"Thilak","thilak@gmail.com","thilak645","Manager");
		//l.add(user1);
		//l.add(user2);
		Mockito.when(userRepository.findByEmailAndPassword(user3.getEmail(), user3.getPassword())).
		thenReturn(user3);
		assertEquals("Manager", userServiceImp.getUsertype(user3.getEmail(),user3.getPassword()));
	}
	@Test
	public void getAlluserByRoleTest() {
		List<User> l= new ArrayList<>();
		l.add(user1);
		l.add(user2);
		Mockito.when(userRepository.getAllByRole(user1.getRole())).thenReturn(l);
		assertEquals(2, userServiceImp.getAllUserByRole(user1.getRole()).size());
	}
	@Test
	public void updateUserTest() {
		User user3=new User(103,"Thilak","thilak@gmail.com","thilak645","manager");
		Mockito.when(userRepository.save(user3)).thenReturn(user3);
		//user3.setUserId(103);
		user3.setUserName("Rakesh");
		user3.setEmail("rakesh@gmail.com");
		user3.setPassword("rakesh322");
		user3.setRole("manager");
		User updateduser=userServiceImp.updateUser(user3);
		//assertThat(updateduser.getUserId()).isEqualTo(103);
		assertThat(updateduser.getUserName()).isEqualTo("Rakesh");
		assertThat(updateduser.getEmail()).isEqualTo("rakesh@gmail.com");
		assertThat(updateduser.getPassword()).isEqualTo("rakesh322");
		assertThat(updateduser.getRole()).isEqualToIgnoringCase("manager");
		//	assertThat(updateduser.getRole()).isEqualTo("manager");
	}
	
	@Test
	public void deleteUserByIdTest() {
		User user4=new User(104,"Hari","hari@gmail.com","stree123","Manager");
		userServiceImp.deleteUserById(user4.getUserId());
		verify(userRepository,times(1)).deleteById(user4.getUserId());
	}
}
