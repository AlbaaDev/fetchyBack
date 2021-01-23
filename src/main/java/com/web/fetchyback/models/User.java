/**
 * 
 */
package com.web.fetchyback.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author abi
 *
 */
@Document(collection = "users")
public class User {
	
	@Id
	private String id;
	private String lastName;
	private String firstName;
	
	/**
	 * @param lastName
	 * @param firstName
	 */
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName  = lastName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + "]";
	}
	
}
