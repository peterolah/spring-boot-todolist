package com.example.todolist.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.todolist.entities.Role;
import com.example.todolist.entities.User;


public class CustomUserDetails implements UserDetails  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8800426996396583250L;
	private final User user;
	
	

	public CustomUserDetails(User user) {
		this.user = user;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (final Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
	}

	@Override
	public String getPassword() {
				return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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
		return user.isEnabled();
	}



	public long getId() {
		return user.getId();
	}
	
	

}
