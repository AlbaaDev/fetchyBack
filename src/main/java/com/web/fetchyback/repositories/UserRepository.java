/**
 * 
 */
package com.web.fetchyback.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.web.fetchyback.models.User;

/**
 * @author abi
 *
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	public User findByFirstName(String lastname);
	public User findByLastName(String lastname);
	
}
