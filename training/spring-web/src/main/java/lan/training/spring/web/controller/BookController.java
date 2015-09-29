package lan.training.spring.web.controller;

import lan.training.core.model.Book;
import lan.training.service.AuthorService;
import lan.training.service.BookService;
import lan.training.service.LanguageService;
import lan.training.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	@Autowired
	AuthorService authorService;
	@Autowired
	PublisherService publisherService;

	@RequestMapping("/list")
	public String listBook(Model model) {
		List<Book> list = bookService.getList();
		model.addAttribute("books", list);
		return "books/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBookForm(Model model) {
		Book book = new Book();
		putModelForForm(model, book);
		return "books/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBook(@Valid Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			putModelForForm(model, book);
			return "books/add";
		}
		bookService.add(book);
		return "redirect:/book/list";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateBook(@PathVariable int id, @Valid Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			putModelForForm(model, book);
			return "books/update";
		}
		bookService.update(book);
		return "redirect:/book/list";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateBookForm(@PathVariable int id, Model model) {
		Book book = bookService.getById(id);
		if (book != null) {
			putModelForForm(model, book);
			return "books/update";
		} else {
			return "redirect:/error";
		}
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		Book book = bookService.getById(id);
		if (book != null) {
			bookService.delete(book);
			return "redirect:/book/list";
		} else {
			return "redirect:/error";
		}
	}

	private void putModelForForm(Model model, Book book) {
		model.addAttribute("book", book);
		model.addAttribute("langs", languageService.getList());
		model.addAttribute("publishers", publisherService.getList());
		model.addAttribute("authors", authorService.getList());
	}
}
