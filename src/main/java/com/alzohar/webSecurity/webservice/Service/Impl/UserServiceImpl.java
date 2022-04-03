package com.alzohar.webSecurity.webservice.Service.Impl;

import com.alzohar.webSecurity.webservice.Entity.User;
import com.alzohar.webSecurity.webservice.Entity.UserService;
import com.alzohar.webSecurity.webservice.Exception.UserAlreadyExistException;
import com.alzohar.webSecurity.webservice.Repository.UserRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository repository;

	@Autowired
	PasswordEncoder encoder;

	@Override
	public User register(User user) {
		User fetchedUser = repository.getUserByUsername(user.getUsername());
		if (fetchedUser != null) {
			LOGGER.error("User already exists for this username :: " + user.getUsername());
			throw new UserAlreadyExistException("User already exists for this email");
		}
		encodePassword(user);
		LOGGER.info(user.getUsername() + " user is registred successfuly. ");
		return repository.save(user);
	}

	private void encodePassword(User user) {
		String encodedPass = encoder.encode(user.getPassword());
		user.setPassword(encodedPass);
	}

}
