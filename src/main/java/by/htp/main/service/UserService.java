package by.htp.main.service;

import by.htp.main.entity.User;

public interface UserService {
	
	public User authorization(User user);
	
	public boolean addNewUser(User user);
	
}
