package com.web.fetchyback.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.fetchyback.repositories.UserRepository;

/**
 * @author abi
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.web.fetchyback.models.User userFromDB = userRepository.findByUserName(username);
		
		if(userFromDB == null) {
			throw new UsernameNotFoundException(username);
		}
		return new LoggedUser(userFromDB.getId(), userFromDB.getUserName(), userFromDB.getPassword());
	}
}
