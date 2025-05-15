package com.user.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.ecommerce.dao.UserRepository;
import com.user.ecommerce.entity.User;

@Service
public class UserService  {

	@Autowired
	private UserRepository repo;


	public List<User> getUsers() {
		return repo.findAll();
	}


	public User createUser(User user) {
		return repo.save(user);
	}


	public User updateUser(int id, User user) {
		Optional<User> existinguser= repo.findById(id);

		if(existinguser.isPresent())
		{
			repo.save(user); 
			return user;
		}
		return null;
	}


	public User getUser(int userId) {
		Optional<User> existinguserOpt = repo.findById(userId);

		if(existinguserOpt.isPresent())
		{
			User existinguser=existinguserOpt.get();
			return existinguser;
		}
		return null;
	}


	public boolean deleteUser(int userId) {
		Optional<User> existinguserOpt = repo.findById(userId);

		if(existinguserOpt.isPresent())
		{
			repo.deleteById(userId);
			return true;
		}

		return false;
	}

}
