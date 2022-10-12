package by.htp.main.dao;

import java.util.List;

import by.htp.main.bean.News;


public interface NewsDAO {
		
	//List<News> getList(int pageNumber, int count) throws NewsDAOException;
	
	List<News> getList();

	//List<News> getLatestsList(int count) throws NewsDAOException;

	News fetchById(int id);

	//boolean addNews(News news) throws NewsDAOException, NewsDAOAddException;

	//boolean updateNews(News news) throws NewsDAOException, NewsDAOUpdateException;

	//void deleteNews(int[] idNews);
	
	void deleteNews(int idNews);

	//boolean deleteNewsFromDB(String idNews) throws NewsDAOException;

	int getNewsListSize();

	void save(News news);
}
