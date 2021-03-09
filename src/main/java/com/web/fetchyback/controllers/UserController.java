package com.web.fetchyback.controllers;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.fetchyback.jwt.JwtRequest;
import com.web.fetchyback.jwt.JwtResponse;
import com.web.fetchyback.jwt.JwtUtility;
import com.web.fetchyback.models.User;
import com.web.fetchyback.repositories.UserRepository;
import com.web.fetchyback.service.UserService;

/**
 * @author abi
 *
 */
@RestController 
@RequestMapping("/users")
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtUtility jwtUtility;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/all")
	public List<User> getAll() {
		return userService.getAll();
	}

	@PostMapping("/register")
	public void register(@RequestBody User userForm) {
		User userToSave = new User();
		userToSave.setEmail(userForm.getEmail());
		userToSave.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
		userService.save(userToSave);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
	     try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            jwtRequest.getEmail(),
	                            jwtRequest.getPassword()
	                    )
	            );
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }

	        final UserDetails userDetails
	                = userService.loadUserByUsername(jwtRequest.getEmail());

	        final String jwtToken =
	                jwtUtility.generateToken(userDetails);
	        return ResponseEntity.ok(new JwtResponse(jwtToken));
	}
}