package by.htp.main.controller;

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

	@Autowired
	private NewsService newsService;

	@RequestMapping("/list")
	public String listNews(Model theModel) {

		try {
			// get news from the service

			List<News> theNews = newsService.list();

			// add the news to the model
			theModel.addAttribute("allNews", theNews);

			return "baseLayout";
		} catch (ServiceNewsException e) {
			return "error";
		}
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		News theNews = new News();

		theModel.addAttribute("news", theNews);

		return "addNews";
	}

	@PostMapping("/saveNews")
	public String save(@ModelAttribute("news") News theNews) {
		try {
			// save the news 
			newsService.save(theNews);

			return "redirect:/news/list";
		} catch (ServiceNewsException e) {
			return "error";
		}
	}

	@GetMapping("/showFormForEdit")
	public String showFormForEdit(@RequestParam("newsId") int theId, Model theModel) {
		try {
			// get the news from our service
			News theNews = newsService.findById(theId);

			// set news as a model attribute to pre-populate the form
			theModel.addAttribute("news", theNews);

			// send over to our form
			return "editNews";
		} catch (ServiceNewsException e) {
			return "error";
		}
	}

	@GetMapping("/view")
	public String viewNews(@RequestParam("newsId") int theId, Model theModel) {
		try {
			// get the news from our service
			News theNews = newsService.findById(theId);

			// set news as a model attribute to pre-populate the form
			theModel.addAttribute("news", theNews);

			return "viewNews";
		} catch (ServiceNewsException e) {
			return "error";
		}
	}

	@GetMapping("/delete")
	public String deleteNews(@RequestParam("newsId") int idNews) {
		try {
			// delete the news
			newsService.deleteNews(idNews);

			return "redirect:/news/list";
		} catch (ServiceNewsException e) {
			return "error";
		}
	}
}
