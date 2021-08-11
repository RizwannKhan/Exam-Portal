package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exam.helper.UserFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.services.UserService;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExamserverApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("starting code");
		LOGGER.info("Starting Application...");
		try {
			User user = new User();

			user.setFirstName("Rizwan");
			user.setLastName("Ahmed");
			user.setUsername("rizwan850");
			user.setPassword(this.bCryptPasswordEncoder.encode("1234"));
			user.setEmail("abc@gmail.com");
			user.setProfile("default.png");

			Role role1 = new Role();

			role1.setRoleId(44L);
			role1.setRoleName("ADMIN");

			Set<UserRole> userRoleSet = new HashSet<>();
			UserRole userRole = new UserRole();
			userRole.setRole(role1);
			userRole.setUser(user);

			userRoleSet.add(userRole);

			User user1 = this.userService.createUser(user, userRoleSet);
			System.out.println(user1.getUsername());
		} catch (UserFoundException e) {
			e.printStackTrace();
		}

	}

}
