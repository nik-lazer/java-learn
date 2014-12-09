package lan.training.spring.web.controller;

import lan.training.spring.model.Book;
import lan.training.spring.model.Language;
import lan.training.spring.service.BookService;
import lan.training.spring.service.CRUDService;
import lan.training.spring.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for actions with books
 * @author nik-lazer  05.12.2014   13:07
 */
@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	LanguageService languageService;

	@RequestMapping("/list")
	public String listBook(Model model) {
		List<Book> list = bookService.getList();
		model.addAttribute("books", list);
		return "books/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBook(@Valid Book book, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "books/add";
		}
		bookService.add(book);
		return "redirect:/book/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		model.addAttribute("langs", languageService.getList());
		return "books/add";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateBook(@PathVariable Integer id, @Valid Book book, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "books/update";
		}
		bookService.update(id, book);
		return "redirect:/book/list";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateBookForm(@PathVariable Integer id, Model model) {
		Book book = bookService.getById(id);
		if (book != null) {
			model.addAttribute("book", book);
			model.addAttribute("langs", languageService.getList());
			return "books/update";
		} else {
			return "redirect:/error";
		}
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable Integer id) {
		Book book = bookService.getById(id);
		if (book != null) {
			bookService.delete(book);
			return "redirect:/book/list";
		} else {
			return "redirect:/error";
		}
	}
}
