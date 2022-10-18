package by.htp.main.dao;

import java.util.List;

import by.htp.main.bean.News;

public interface NewsDAO {

	List<News> getList() throws NewsDAOException;

	News fetchById(int id) throws NewsDAOException;

	void deleteNews(int idNews) throws NewsDAOException;

	void save(News news) throws NewsDAOException;

	void saveNewNews(News news) throws NewsDAOException;
}
