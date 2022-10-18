package by.htp.main.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.main.bean.News;
import by.htp.main.service.NewsService;
import by.htp.main.service.ServiceNewsException;

@Controller
@RequestMapping("/news")
public class NewsController {

	private static final String DATE_FORMAT_FOR_VIEW = "dd/MM/yyyy";
	private static final String DATE_FORMAT_FROM_SERVER = "yyyy-MM-dd";
	private static final String ALL_NEWS = "allNews";
	private static final String JSP_BASE_PAGE_NAME = "baseLayout";
	private static final String JSP_PAGE_ERROR = "error";
	private static final String REDIRECT_REQUEST = "redirect:/news/list";
	private static final String MODEL_NAME_FOR_EDIT = "newsForEdit";
	private static final String MODEL_NAME_FOR_ADD = "newsForAdd";
	private static final String MODEL_NAME_FOR_VIEW = "newsForView";

	@Autowired
	private NewsService newsService;

	@RequestMapping("/list")
	public String listNews(Model theModel) throws ParseException {

		try {
			// get news from the service

			List<News> theNews = newsService.list();

			for (int i = 0; i < theNews.size(); i++) {
				theNews.get(i).setNewsDate(convertDateToString(theNews.get(i)));
			}

			// add the news to the model
			theModel.addAttribute(ALL_NEWS, theNews);

			return JSP_BASE_PAGE_NAME;
		} catch (ServiceNewsException e) {
			return JSP_PAGE_ERROR;
		}
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		News theNews = new News();

		theModel.addAttribute(MODEL_NAME_FOR_ADD, theNews);

		return JSP_BASE_PAGE_NAME;
	}

	@PostMapping("/saveNews")
	public String save(@ModelAttribute("news") News theNews) {
		try {
			// save the news
			newsService.save(theNews);

			return REDIRECT_REQUEST;
		} catch (ServiceNewsException e) {
			return JSP_PAGE_ERROR;
		}
	}

	@PostMapping("/addNews")
	public String saveNewNews(@ModelAttribute("news") News theNews) {
		try {
			// save the news
			newsService.addNews(theNews);

			return REDIRECT_REQUEST;
		} catch (ServiceNewsException e) {
			return JSP_PAGE_ERROR;
		}
	}

	@GetMapping("/showFormForEdit")
	public String showFormForEdit(@RequestParam("newsId") int theId, Model theModel) throws ParseException {
		try {
			// get the news from our service
			News theNews = newsService.findById(theId);

			theNews.setNewsDate(convertDateToString(theNews));

			// set news as a model attribute to pre-populate the form
			theModel.addAttribute(MODEL_NAME_FOR_EDIT, theNews);

			// send over to our form
			return JSP_BASE_PAGE_NAME;
		} catch (ServiceNewsException e) {
			return JSP_PAGE_ERROR;
		}
	}

	@GetMapping("/view")
	public String viewNews(@RequestParam("newsId") int theId, Model theModel) throws ParseException {
		try {
			// get the news from our service
			News theNews = newsService.findById(theId);

			theNews.setNewsDate(convertDateToString(theNews));

			// set news as a model attribute to pre-populate the form
			theModel.addAttribute(MODEL_NAME_FOR_VIEW, theNews);

			return JSP_BASE_PAGE_NAME;
		} catch (ServiceNewsException e) {
			return JSP_PAGE_ERROR;
		}
	}

	@GetMapping("/delete")
	public String deleteNews(@RequestParam("newsId") int idNews) {
		try {
			// delete the news
			newsService.deleteNews(idNews);

			return REDIRECT_REQUEST;
		} catch (ServiceNewsException e) {
			return JSP_PAGE_ERROR;
		}
	}

	private String convertDateToString(News news) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_FOR_VIEW);
		Timestamp timestamp = Timestamp.valueOf(news.getNewsDate());
		// DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		String date = sdf.format(timestamp);

		return date;
	}
}
