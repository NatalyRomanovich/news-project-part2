package by.htp.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.htp.main.bean.News;
import by.htp.main.dao.NewsDAO;
import by.htp.main.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDAO newsDAO;

	// private static final int FIRST_SYMBOL = 0;
	// private static final int BRIEF_LENGTH = 100;

	@Transactional
	//@Override
	public List<News> list() {

		return newsDAO.getList();
	}

	@Transactional
	//@Override
	public void save(News news) {
		newsDAO.save(news);
	}

	@Transactional
	//@Override
	public int getNewsListSize() {

		return newsDAO.getNewsListSize();
	}

	@Transactional
	//@Override
	public News findById(int id) {
		return newsDAO.fetchById(id);
	}
	
	@Transactional
	//@Override
	public void deleteNews(int idNews) {

		newsDAO.deleteNews(idNews);
	}

	/*@Transactional
	//@Override
	public void deleteNews(String[] idNews) {

		newsDAO.deleteNews(idNews);
	}*/
}