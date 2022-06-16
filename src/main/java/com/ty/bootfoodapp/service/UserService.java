package com.ty.bootfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bootfoodapp.dao.UserDao;
import com.ty.bootfoodapp.dto.User;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	public User saveUser(User user) {
		return dao.saveUser(user);
	}

	public User getUserById(int id) {
		return dao.getUserById(id);
	}

	public String deleteUserbyId(int id) {
		return dao.deleteUserbyId(id);
	}

	public User validateUser(String email, String password) {
		return dao.validateUser(email, password);
	}

	public List<User> getAllUser() {
		return dao.getAllUser();
	}
}
