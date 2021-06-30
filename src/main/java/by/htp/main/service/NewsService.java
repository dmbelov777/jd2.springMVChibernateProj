package by.htp.main.service;

import java.util.List;

import by.htp.main.entity.News;

public interface NewsService {

	public List<News> getNews();
	
	public void changeNews(News news);
	
	public void delNews(int idnews);
	
}
