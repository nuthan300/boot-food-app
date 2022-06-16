package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bootfoodapp.dto.User;
import com.ty.bootfoodapp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	
	public User getUserById( int id) {
		Optional<User> optional= userRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public String deleteUserbyId( int id) {
		Optional<User> optional= userRepository.findById(id);
		if(optional.isPresent()) {
			userRepository.deleteById(id);
			return "Deleted User";
		}
		return "Couldn't find user";

	}

	public User validateUser(String email, String password) {
		return userRepository.validateUser(email, password);	
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}
}
