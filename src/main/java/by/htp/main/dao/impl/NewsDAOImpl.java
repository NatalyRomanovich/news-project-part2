package by.htp.main.dao.impl;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.main.bean.News;
import by.htp.main.controller.NewsParameter;
import by.htp.main.dao.NewsDAO;
import by.htp.main.dao.NewsDAOException;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;


@Repository
public class NewsDAOImpl implements NewsDAO {

	private static final String DATE_FORMAT_FOR_VIEW = "dd/MM/yyyy";
	private static final String DATE_FORMAT_FROM_SERVER = "yyyy-MM-dd";
	private static final String NOT_DELETING = "no";
	private static final String DELETED_NEWS = "yes";
	private static final String ID_ADMIN_ROLE = "1";

	@Autowired
	private SessionFactory sessionFactory;

	private static final String SHOW_NEWS_ON_ONE_PAGE = "from News where deleted=:deletedNewsMark order by date desc, id_news desc";

	// @Override
	public List<News> getList() throws NewsDAOException {

		try {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// create a query ... sort by last date
			Query<News> theQuery = currentSession.createQuery(SHOW_NEWS_ON_ONE_PAGE, News.class);

			theQuery.setParameter(NewsParameter.DELETED_NEWS_MARK, NOT_DELETING);
			
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
			news.setNewsDate(convertDateToDBFormat (news.getNewsDate(), DATE_FORMAT_FOR_VIEW).toString());
			
			currentSession.saveOrUpdate(news);

		} catch (Exception e) {
			throw new NewsDAOException("Something is wrong. Failed to save news", e);

		}
	}

	// @Override
	public void saveNewNews(News news) throws NewsDAOException {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			news.setUsersId(ID_ADMIN_ROLE);
			news.setDeletedNewsMark(NOT_DELETING);
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

	// private static final String DELETE_NEWS = "delete from News where
	// id_news=:idNews";
	private static final String DELETE_NEWS = "update from News set deleted =:deletedNewsMark where id_news=:idNews";

	// @Override
	public void deleteNews(int idNews) throws NewsDAOException {
		try {
			// get the current hibernate session

			Session currentSession = sessionFactory.getCurrentSession();

			// delete object with primary key
			Query theQuery = currentSession.createQuery(DELETE_NEWS);

			theQuery.setParameter(NewsParameter.ID_NEWS, idNews);
			theQuery.setParameter(NewsParameter.DELETED_NEWS_MARK, DELETED_NEWS);
			theQuery.executeUpdate();
		} catch (Exception e) {
			throw new NewsDAOException("Something is wrong. Could not delete news.", e);
		}
	}

	private Timestamp convertDateToDBFormat(String dateStr, String format) throws ParseException {

		DateFormat formatter = new SimpleDateFormat(format);
		Date date = formatter.parse(dateStr);
		Timestamp ts = new Timestamp(date.getTime());
		return ts;
	}

	private String convertDateToString(News news) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_FOR_VIEW);
		Timestamp timestamp = Timestamp.valueOf(news.getNewsDate());
		// DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		String date = sdf.format(timestamp);

		return date;
	}

}
