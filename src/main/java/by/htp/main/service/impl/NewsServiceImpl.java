package by.htp.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.htp.main.bean.News;
import by.htp.main.dao.NewsDAO;
import by.htp.main.dao.NewsDAOException;
import by.htp.main.service.NewsService;
import by.htp.main.service.ServiceNewsException;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDAO newsDAO;

	

	@Transactional
	// @Override
	public List<News> list() throws ServiceNewsException {
		try {
			return newsDAO.getList();
		} catch (NewsDAOException e) {
			throw new ServiceNewsException(e);
		}
	}

	@Transactional
	// @Override
	public void save(News news) throws ServiceNewsException {
		try {
			newsDAO.save(news);
		} catch (NewsDAOException e) {
			throw new ServiceNewsException(e);
		}
	}
	
	@Transactional
	// @Override
	public void addNews(News news) throws ServiceNewsException {
		try {
			newsDAO.saveNewNews(news);
		} catch (NewsDAOException e) {
			throw new ServiceNewsException(e);
		}
	}
	
	@Transactional
	// @Override
	public News findById(int id) throws ServiceNewsException {
		try {
			return newsDAO.fetchById(id);
		} catch (NewsDAOException e) {
			throw new ServiceNewsException(e);
		}
	}

	@Transactional
	// @Override
	public void deleteNews(int idNews) throws ServiceNewsException {
		try {
			newsDAO.deleteNews(idNews);
		} catch (NewsDAOException e) {
			throw new ServiceNewsException(e);
		}
	}

	/*
	 * @Transactional //@Override public void deleteNews(String[] idNews) {
	 * 
	 * newsDAO.deleteNews(idNews); }
	 */
}