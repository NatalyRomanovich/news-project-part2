package by.htp.main.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.main.bean.News;
import by.htp.main.dao.NewsDAO;
import by.htp.main.dao.NewsDAOException;

@Repository
public class NewsDAOImpl implements NewsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final String SHOW_NEWS_ON_ONE_PAGE = "from News order by date desc, id_news desc";

	// @Override
	public List<News> getList() throws NewsDAOException {

		try {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// create a query ... sort by last date
			Query<News> theQuery = currentSession.createQuery(SHOW_NEWS_ON_ONE_PAGE, News.class);

			// execute query and get result news list
			List<News> listNews = theQuery.getResultList();

			// return the results
			return listNews;
		} catch (Exception e) {
			throw new NewsDAOException("Something is wrong with the database", e);

		}

	}

	// @Override
	public void save(News news) throws NewsDAOException {
		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(news);
		} catch (Exception e) {
			throw new NewsDAOException("Something is wrong. Failed to save news", e);

		}
	}

	// @Override
	public News fetchById(int id) throws NewsDAOException {
		try {
			// get the current hibernate session

			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using the primary key
			News theNews = currentSession.get(News.class, id);

			return theNews;
		} catch (Exception e) {
			throw new NewsDAOException("Something is wrong. Could not find news.", e);
		}
	}

	private static final String DELETE_NEWS = "delete from News where id_news=:idNews";

	// @Override
	public void deleteNews(int idNews) throws NewsDAOException {
		try {
			// get the current hibernate session

			Session currentSession = sessionFactory.getCurrentSession();

			// delete object with primary key
			Query theQuery = currentSession.createQuery(DELETE_NEWS);

			theQuery.setParameter("idNews", idNews);

			theQuery.executeUpdate();
		} catch (Exception e) {
			throw new NewsDAOException("Something is wrong. Could not elete news.", e);
		}
	}

	
}
