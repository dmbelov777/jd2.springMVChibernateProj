package by.htp.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.main.entity.News;

@Repository
public class NewsDAOImpl implements NewsDAO {

	private static final String ALL_NEWS = "FROM News";
	private static final String CHANGE_NEWS = "UPDATE News set title = :nameTitle, brief = :nameBrief, content = :nameContent WHERE idnews = :idCode";
	private static final String TITLE = "nameTitle";
	private static final String BRIEF = "nameBrief";
	private static final String CONTENT = "nameContent";
	private static final String ID_NEWS = "idCode";
	private static final String DELETE_NEWS = "UPDATE News set status = :nameStatus WHERE idnews = :idCode";
	private static final String STATUS = "nameStatus";
	private static final String STATUS_DELETE = "deleted";
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<News> getNews() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<News> query = session.createQuery(ALL_NEWS);
		
		return query.getResultList();
	}

	public void changeNews(News news) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery(CHANGE_NEWS);
		
		query.setParameter(TITLE, news.getTitle());
		query.setParameter(BRIEF, news.getBrief());
		query.setParameter(CONTENT, news.getContent());
		query.setParameter(ID_NEWS, news.getIdnews());
		
		query.executeUpdate();
	}

	public void delNews(int idnews) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery(DELETE_NEWS);
		
		query.setParameter(STATUS, STATUS_DELETE);
		query.setParameter(ID_NEWS, idnews);
		
		query.executeUpdate();
	}
}
