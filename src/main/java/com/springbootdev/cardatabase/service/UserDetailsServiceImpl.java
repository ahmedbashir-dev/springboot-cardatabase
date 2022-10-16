package com.springbootdev.cardatabase.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootdev.cardatabase.domain.User;
import com.springbootdev.cardatabase.domain.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findByUsername(username);
		UserBuilder builder = null;
		if(user.isPresent()) {
			User currentUser = user.get();
			builder = org.springframework.security.core.userdetails.
					User.withUsername(username);
			builder.password(currentUser.getPassword());
			builder.roles(currentUser.getRole());
		}
		else {
			throw new UsernameNotFoundException("User not found");
		}
		return builder.build();
	}

}
