package com.alzohar.webSecurity.webservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.alzohar.webSecurity.webservice.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("Select u FROM User u WHERE u.username =:username")
	public User getUserByUsername(@PathVariable("username") String username);
}
