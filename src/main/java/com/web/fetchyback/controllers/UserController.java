package com.web.fetchyback.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.fetchyback.models.User;
import com.web.fetchyback.repositories.UserRepository;

/**
 * @author abi
 *
 */
@RestController 
@RequestMapping("/users")
public class UserController {
	
	private UserRepository userRepository;
	
	/**
	 * @param userRepository
	 */
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/all")
	public List<User> index() {
		return userRepository.findAll();
	}
}