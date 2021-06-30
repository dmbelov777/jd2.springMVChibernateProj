package by.htp.main.dao;

import java.util.List;

import by.htp.main.entity.News;

public interface NewsDAO {

	public List<News> getNews();
	
	public void changeNews(News news);
	
	public void delNews(int idnews);
	
}
