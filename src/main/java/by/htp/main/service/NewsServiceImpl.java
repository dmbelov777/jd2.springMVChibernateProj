package by.htp.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.main.dao.NewsDAO;
import by.htp.main.entity.News;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDAO newsDAO;
	
	@Transactional
	public List<News> getNews() {
		return newsDAO.getNews();
	}

	@Transactional
	public void changeNews(News news) {
		newsDAO.changeNews(news);
	}
	
	@Transactional
	public void delNews(int idnews) {
		newsDAO.delNews(idnews);
	}

}
