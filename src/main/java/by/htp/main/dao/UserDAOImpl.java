package by.htp.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.main.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public User getUser(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("FROM User u WHERE u.login='" + user.getLogin() + "' AND u.password='" 
													+ user.getPassword() + "'", User.class);
		
		List<User> userList = query.getResultList();
		
		return userList.size() < 1 ? null : userList.get(0);
	}
	
	public boolean addNewUser(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("FROM User");
		
		List<User> users = query.getResultList();
		
		for (User u : users) {
			if(u.getPhone().equals(user.getPhone()) || u.getLogin().equals(user.getLogin()))
				return false;
		}
		
		session.saveOrUpdate(user);
	
		return true;
	}
}
