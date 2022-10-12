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
import by.htp.main.dao.NewsDAOAddException;
import by.htp.main.dao.NewsDAODeleteException;
import by.htp.main.dao.NewsDAOException;
import by.htp.main.dao.NewsDAOUpdateException;

@Repository
public class NewsDAOImpl implements NewsDAO {

	// private static final int ADMIN_ROLE_ID = 1;
	// private static final String DATE_FORMAT_FOR_VIEW = "dd/MM/yyyy";
	// private static final String DATE_FORMAT_FROM_SERVER = "yyyy-MM-dd";
	// private static final String NEWS_DELETED = "yes";
	// private static final String IS_NOT_DELETED_NEWS = "no";
	// private static final String COUNT = "COUNT(*)";

	// private static final String SHOW_LATEST_NEWS_FOR_GUEST = "SELECT * FROM news
	// WHERE deleted=? ORDER BY date DESC LIMIT ?";

	@Autowired
	private SessionFactory sessionFactory;

	private static final String SHOW_NEWS_ON_ONE_PAGE = "from News order by date desc, id_news desc";

	// @Override
	public List<News> getList() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last date
		Query<News> theQuery = currentSession.createQuery(SHOW_NEWS_ON_ONE_PAGE, News.class);

		// execute query and get result list
		List<News> listNews = theQuery.getResultList();

		// return the results
		return listNews;
	}

	// @Override
	public void save(News news) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(news);
	}

	// @Override
	public News fetchById(int id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		News theNews = currentSession.get(News.class, id);

		return theNews;
	}

	private static final String DELETE_NEWS = "delete from News where id_news=:idNews";

	// @Override
	public void deleteNews(int idNews) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
			// delete object with primary key
			Query theQuery = currentSession.createQuery(DELETE_NEWS);

			theQuery.setParameter("idNews", idNews);

			theQuery.executeUpdate();		

	}
	
	
	/*// @Override
		public void deleteNews(int [] idNews) {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			for (String id : idNews) {
				// delete object with primary key
				Query theQuery = currentSession.createQuery(DELETE_NEWS);

				theQuery.setParameter("idNews", id);

				theQuery.executeUpdate();
			}

		}*/

	// @Override
	public int getNewsListSize() {

		int count = 0;
		/*
		 * try (Connection connection = ConnectionPool.getInstance().takeConnection();
		 * PreparedStatement ps = connection.prepareStatement(NUMBER_OF_NEWS_SELECT)) {
		 * ps.setString(1, IS_NOT_DELETED_NEWS); ResultSet rs = ps.executeQuery(); while
		 * (rs.next()) { count = rs.getInt(COUNT); } return count;
		 * 
		 * } catch (SQLException e) { throw new
		 * NewsDAOException("Something is wrong with the database", e);
		 * 
		 * } catch (ConnectionPoolException e) { throw new
		 * NewsDAOException("Connection is not established", e); }
		 */
		return count;
	}

	// private static final String VIEW_NEWS_BY_ID = "SELECT * FROM news WHERE
	// id_news=?";

	// private static final String UPDATE_NEWS = "UPDATE news SET title = ? , brief
	// = ?, content = ? , date = ? WHERE id_news = ?";

	// private static final String DELETE_NEWS_COMPLETELY_FROM_DB = "DELETE FROM
	// news WHERE id_news = ?";

	/*
	 * @Override public boolean deleteNewsFromDB(String idNews) throws
	 * NewsDAOException { try (Connection connection =
	 * ConnectionPool.getInstance().takeConnection(); PreparedStatement ps =
	 * connection.prepareStatement(DELETE_NEWS_COMPLETELY_FROM_DB)) { ps.setInt(1,
	 * Integer.parseInt(idNews)); ps.executeUpdate(); } catch (SQLException e) {
	 * throw new NewsDAOException("Something is wrong with the database", e); }
	 * catch (ConnectionPoolException e) { throw new
	 * NewsDAOException("Connection is not established", e); } return true; }
	 */
	// private static final String DELETE_NEWS = "UPDATE news SET deleted=? WHERE
	// id_news = ?";

	/*
	 * private Timestamp convertDateToDBFormat(String dateStr, String format) throws
	 * NewsDAOException { try { DateFormat formatter = new SimpleDateFormat(format);
	 * Date date = formatter.parse(dateStr); Timestamp ts = new
	 * Timestamp(date.getTime()); return ts; } catch (ParseException e) { throw new
	 * NewsDAOException(e); } }
	 * 
	 * private String convertDateToString(ResultSet rs) throws SQLException {
	 * SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_FOR_VIEW); Timestamp
	 * timestamp = rs.getTimestamp(5); String date = sdf.format(timestamp); return
	 * date; }
	 */
}
