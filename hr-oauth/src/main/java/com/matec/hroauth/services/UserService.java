package com.matec.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.matec.hroauth.entities.User;
import com.matec.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService{
	
	Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User fingByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if(user == null) {
			log.error("Email not found " + email);
			throw new IllegalArgumentException("Email not found");
		}

		log.info("Email found " + email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username).getBody();
		if(user == null) {
			log.error("Email not found " + username);
			throw new UsernameNotFoundException("Email not found");
		}

		log.info("Email found " + username);
		return user;
	}
}
