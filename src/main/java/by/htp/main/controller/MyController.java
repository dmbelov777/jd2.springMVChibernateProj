package by.htp.main.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.htp.main.entity.News;
import by.htp.main.entity.User;
import by.htp.main.service.NewsService;
import by.htp.main.service.UserService;


@Controller
public class MyController {
	
	private static final String MESSAGE = "message";
	private static final String WRONG_LOGIN_INFO = "Wrong login or password";
	private static final String LOGIN_INFO_OK = "Welcome, ";
	private static final String REGINFO_FAIL = "Please, fill all fields";
	private static final String USER_EXISTS = "User exists. Please sign in";
	private static final String NEWS = "news";
	private static final String USER = "user";
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping("/mainPage")
	public String goToMainPage(Model model){
		model.addAttribute("user", new User());
		return "main-page";
	}
	
	@RequestMapping("/logination")
	public String logination(@ModelAttribute("user") User user, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		
		User theUser = userService.authorization(user);
		
		if(theUser == null) {
			redirectAttributes.addAttribute(MESSAGE, WRONG_LOGIN_INFO);
			return ("redirect:mainPage");
		}

		model.addAttribute(MESSAGE, LOGIN_INFO_OK + theUser.getFirstName() + " " + theUser.getLastName());
		
		session.setAttribute(USER, theUser);
		
		List<News> news = newsService.getNews();
		
		model.addAttribute(NEWS, news);
		
		return "news-page";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model) {
		
		model.addAttribute("user", new User());
		
		return "registration-page";
	}
	
	@RequestMapping("/saveNewUser")
	public String saveNewUser(@ModelAttribute ("user") User user, Model model) {
		
		String message = "";
		
		if (user.getFirstName() == "" || user.getLastName() == "" || user.getYear() == 0 
				|| user.getPhone() == "" || user.getLogin() == "" || user.getPassword() == "") {
			message += REGINFO_FAIL;
			model.addAttribute(MESSAGE, message);
			return "registration-page";
		}
		
		if(!userService.addNewUser(user)) {
			message += USER_EXISTS;
			model.addAttribute(MESSAGE, message);
			return "registration-page";
		}
		
		
		message += LOGIN_INFO_OK + user.getFirstName() + " " + user.getLastName();
		
		model.addAttribute(MESSAGE, message);
		
		List<News> news = newsService.getNews();
		
		model.addAttribute(NEWS, news);
		
		return "news-page";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("user", new User());
		return "main-page";
	}
	
	@RequestMapping("/gotocontentpage")
	public String goToContentPage(@RequestParam("currentId") int currentId, Model model, HttpSession session) {
	

		List<News> news = newsService.getNews();
		
		News theNews = null;
		
		for (News n : news) {
			if(n.getIdnews() == currentId) {
				theNews = n;
				break;
			}
		}
		
		model.addAttribute(NEWS, theNews);
		
		User theUser = (User) session.getAttribute(USER);
		model.addAttribute(USER, theUser);	
		
		return "content-page";
	}
	
	@RequestMapping("/gotonewspage")
	public String goToNewsPage(Model model) {
		
		List<News> news = newsService.getNews();
		
		model.addAttribute(NEWS, news);
		
		return "news-page";
	}
	
	@RequestMapping("/editnews")
	public String editNews(@ModelAttribute("news") News news, Model model) {
		model.addAttribute(NEWS, news);
		return "edit-page";
	}
	
	
	@RequestMapping("/saveeditnews")
	public String saveEditNews(@ModelAttribute("news") News news, Model model, HttpSession session) {
			
			newsService.changeNews(news);
			
			List<News> listNews = newsService.getNews();
			
			News theNews = null;
			
			for (News n : listNews) {
				if(n.getIdnews() == news.getIdnews()) {
					theNews = n;
					break;
				}
			}
			
			model.addAttribute(NEWS, theNews);
			
			User theUser = (User) session.getAttribute(USER);
			model.addAttribute(USER, theUser);
		
		return "content-page";
	}
	
	@RequestMapping("/deletenews")
	public String deleteNews(@ModelAttribute("news") News news, Model model) {
		
		newsService.delNews(news.getIdnews());
		
		List<News> listNews = newsService.getNews();
		
		model.addAttribute(NEWS, listNews);
		
		return "news-page";
	}
	
}

