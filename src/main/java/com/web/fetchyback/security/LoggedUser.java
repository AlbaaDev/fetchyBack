/**
 * 
 */
package com.web.fetchyback.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author abi
 *
 */
public class LoggedUser implements UserDetails {
	
	private final long id;
	private final String userName;
    private final String password;
    
    public LoggedUser(long id, String userName, String password) {
    	this.id = id;
    	this.userName = userName;
		this.password = password;
	}
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
    /**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
