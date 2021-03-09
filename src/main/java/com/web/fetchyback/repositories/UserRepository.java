/**
 * 
 */
package com.web.fetchyback.repositories;

import java.awt.List;

import org.springframework.data.mongodb.repository.MongoRepository; 
import org.springframework.stereotype.Repository;

import com.web.fetchyback.models.User;
 
/**
 * @author abi
 *
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	public User findByEmail(String email);
}
