package com.alzohar.webSecurity.webservice.Controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alzohar.webSecurity.webservice.Entity.User;
import com.alzohar.webSecurity.webservice.Entity.UserService;
import com.alzohar.webSecurity.webservice.Repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserService useService;

	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") long id) {
		Optional<User> user = userRepo.findById(id);
		if (user != null) {
			LOGGER.info("User is found with id :: " + id);
			return user;
		}
		LOGGER.info("User is not found with id " + id);
		throw new UsernameNotFoundException("User Not Found For Given id" + id);
	}

	@GetMapping("/users")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<User> getUsers() {
		List<User> list = userRepo.findAll();
		if (list.isEmpty()) {
			LOGGER.info("User is not found , user list is empty ");
			throw new UsernameNotFoundException("User Not Found ");
		}
		LOGGER.info("Get users list is successfull");
		return list;
	}

	@PostMapping("/users")
	@PreAuthorize("hasAuthority('ADMIN')")
	public User addUser(@Valid @RequestBody User user) {
		return userRepo.save(user);
	}

	@PutMapping("/users")
	@PreAuthorize("hasAnyAuthority('VENDOR', 'ADMIN')")
	public User updateUser(@Valid @RequestBody User user) {
		return userRepo.save(user);
	}

	@DeleteMapping("/users/{id}")
	@PreAuthorize("hasAnyAuthority('VENDOR', 'ADMIN')")
	public String deleteUserById(@Valid @PathVariable("id") long id) {
		userRepo.deleteById(id);
		return "User Delete Succesfully ";
	}
}
