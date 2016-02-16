package lan.training.spring.web.controller;

import lan.training.service.AuthorService;
import lan.training.service.PublisherService;
import lan.training.spring.web.dto.BookDto;
import lan.training.spring.web.service.AuthorDtoService;
import lan.training.spring.web.service.BookDtoService;
import lan.training.spring.web.service.LanguageDtoService;
import lan.training.spring.web.service.PublisherDtoService;
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
	BookDtoService bookService;
	@Autowired
	LanguageDtoService languageService;
	@Autowired
	AuthorDtoService authorService;
	@Autowired
	PublisherDtoService publisherService;

	@RequestMapping("/list")
	public String listBook(Model model) {
		List<BookDto> list = bookService.getList();
		model.addAttribute("books", list);
		return "books/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBookForm(Model model) {
		BookDto book = new BookDto();
		putModelForForm(model, book);
		return "books/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBook(@Valid BookDto book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			putModelForForm(model, book);
			return "books/add";
		}
		bookService.add(book);
		return "redirect:/book/list";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateBook(@PathVariable int id, @Valid BookDto book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			putModelForForm(model, book);
			return "books/update";
		}
		bookService.update(book);
		return "redirect:/book/list";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateBookForm(@PathVariable int id, Model model) {
		BookDto book = bookService.getById(id);
		if (book != null) {
			putModelForForm(model, book);
			return "books/update";
		} else {
			return "redirect:/error";
		}
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		BookDto book = bookService.getById(id);
		if (book != null) {
			bookService.delete(book);
			return "redirect:/book/list";
		} else {
			return "redirect:/error";
		}
	}

	private void putModelForForm(Model model, BookDto bookDto) {
		model.addAttribute("book", bookDto);
		model.addAttribute("langs", languageService.getList());
		model.addAttribute("publishers", publisherService.getList());
		model.addAttribute("authors", authorService.getList());
	}
}
