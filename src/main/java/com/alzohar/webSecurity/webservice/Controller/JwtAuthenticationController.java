package com.alzohar.webSecurity.webservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alzohar.webSecurity.webservice.Entity.User;
import com.alzohar.webSecurity.webservice.Entity.UserService;
import com.alzohar.webSecurity.webservice.Security.JWTResponse;
import com.alzohar.webSecurity.webservice.Security.JWTTokenUtil;
import com.alzohar.webSecurity.webservice.Security.JwtUser;
import com.alzohar.webSecurity.webservice.Service.Impl.JWTUserDetailsService;

@RestController
public class JwtAuthenticationController {

	@Autowired
	private JWTUserDetailsService jwtUserSrv;

	@Autowired
	private JWTTokenUtil jwtToken;

	@Autowired
	private UserService useService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthToken(@RequestBody JwtUser user) throws Exception {
		String token = null;
		UserDetails userDetails = jwtUserSrv.loadUserByUsername(user.getUsername());
		if (userDetails != null) {
			token = jwtToken.generateToken(userDetails);
			return ResponseEntity.ok(new JWTResponse(token));
		}
		throw new UsernameNotFoundException("User not found !");
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		User userCreated = useService.register(user);
		if (userCreated != null) {
			return ResponseEntity.ok(userCreated);
		}
		throw new UsernameNotFoundException("User Registration failed !");
	}

}
