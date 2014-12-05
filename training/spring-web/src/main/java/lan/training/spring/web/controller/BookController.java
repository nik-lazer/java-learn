package lan.training.spring.web.controller;

import lan.training.spring.model.Book;
import lan.training.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping("/list")
	public String listBook(Model model) {
		List<Book> list = bookService.getBooks();
		model.addAttribute("books", list);
		return "books/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBook(Book book) {
		bookService.addBook(book);
		return "redirect:/book/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "books/add";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateBook(@PathVariable Integer id, Book book, Model model) {
		bookService.updateBook(id, book);
		return "redirect:/book/list";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateBookForm(@PathVariable Integer id, Model model) {
		Book book = bookService.getById(id);
		if (book != null) {
			model.addAttribute("book", book);
			return "books/update";
		} else {
			return "redirect:/error";
		}
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable Integer id) {
		Book book = bookService.getById(id);
		if (book != null) {
			bookService.deleteBook(book);
			return "redirect:/book/list";
		} else {
			return "redirect:/error";
		}
	}
}
