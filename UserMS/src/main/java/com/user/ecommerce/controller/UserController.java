package com.user.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.ecommerce.entity.User;
import com.user.ecommerce.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User b = service.createUser(user);
		return new ResponseEntity<User>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user){
		
		User b = service.updateUser(id, user);
		return new ResponseEntity<User>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
		boolean isDeleted = service.deleteUser(id);
		if(isDeleted){
			String responseContent = "User has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting user from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getUsers(){
		
		List<User> users = service.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
		User user = service.getUser(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
