package by.htp.main.service;

import java.util.List;

import by.htp.main.bean.News;

public interface NewsService {

	List<News> list() throws ServiceNewsException;

	News findById(int id) throws ServiceNewsException;

	void save(News news) throws ServiceNewsException;

	void deleteNews(int idNews) throws ServiceNewsException;

}
