package by.htp.main.service;

import java.util.List;

import by.htp.main.bean.News;

public interface NewsService {

	//void find() throws ServiceNewsException;

	//boolean update(News news) throws ServiceNewsException, ServiceValidationNewsException;

	//List<News> latestList(int count) throws ServiceNewsException;

	List<News> list();
	
	//List<News> list(int pageNumber, int count) throws ServiceNewsException;

	News findById(int id);

	void save (News news);

	//void deleteNews(int[] idNews);
	
	void deleteNews(int idNews);

	//boolean deleteNewsFromDB(String idNews) throws ServiceNewsException;

	int getNewsListSize();

}
