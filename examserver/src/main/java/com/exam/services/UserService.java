package com.exam.services;

import java.util.Set;
import com.exam.model.User;
import com.exam.model.UserRole;

public interface UserService {
	
	//creating user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	//get user by username
	public User getUser(String username);
	
	//delete user by username or id
	public void deleteUser(Long userId);
	
	//update user

}
