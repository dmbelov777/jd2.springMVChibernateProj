package by.htp.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.main.dao.UserDAO;
import by.htp.main.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public User authorization(User user) {
		
		User serviceUser = userDAO.getUser(user);
		
		return serviceUser == null ? null : serviceUser;
	}

	@Transactional
	public boolean addNewUser(User user) {
		
		user.setRole("user");
		
		if(!userDAO.addNewUser(user)) {
			return false;
		}
		
		return true;
	}
}
