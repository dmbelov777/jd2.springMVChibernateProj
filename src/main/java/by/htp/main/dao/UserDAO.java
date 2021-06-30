package by.htp.main.dao;

import by.htp.main.entity.User;

public interface UserDAO {

	public User getUser(User user);
	
	public boolean addNewUser(User user);
}
