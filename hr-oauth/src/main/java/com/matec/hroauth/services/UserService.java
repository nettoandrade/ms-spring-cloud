package com.matec.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matec.hroauth.entities.User;
import com.matec.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	
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
}
