package lan.training.dao.web.controller;

import lan.training.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Home controller for application
 * @author nik-lazer 03.12.2014   13:15
 */
@Controller
public class HomeController {
	@Autowired
	private BookService bookService;

	@RequestMapping({"/","/home"})
	public String showHomePage(Map<String, Object> model) {
		model.put("books", bookService.getList());
		return "home";
	}

}
