/**
 * 
 */
package com.web.fetchyback;

import java.nio.charset.Charset; 
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.web.fetchyback.models.User;
import com.web.fetchyback.repositories.UserRepository;

/**
 * @author abi
 *
 */
//@Component
//public class Seeder implements CommandLineRunner {
//	
//	@Autowired
//	private UserRepository repository;
//	
//	@Override
//	public void run(String... args) throws Exception {
//	  this.repository.deleteAll();
//	  int j = 0;
//	  for (int i = 1; i < 10; i++) {
//		j = i + 1;
//		repository.save(new User("" + i, "" + j));
//	  }
//	}
//}
