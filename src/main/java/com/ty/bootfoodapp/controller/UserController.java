package com.ty.bootfoodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bootfoodapp.dto.Login;
import com.ty.bootfoodapp.dto.User;
import com.ty.bootfoodapp.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;

	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		return service.getUserById(id);
	}

	@DeleteMapping("/users/{id}")
	public String deleteUserbyId(@PathVariable int id) {
		return service.deleteUserbyId(id);
	}

	@PostMapping("/users/login")
	public User validateUser(@RequestBody Login login) {
		return service.validateUser(login.getEmail(), login.getPassword());
	}

	@GetMapping("/users")
	public List<User> getAllUser() {
		return service.getAllUser();
	}	
}