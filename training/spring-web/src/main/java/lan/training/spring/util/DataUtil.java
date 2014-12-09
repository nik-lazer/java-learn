package lan.training.spring.util;

import lan.training.spring.model.Book;
import lan.training.spring.model.Language;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Utilitary functions
 * @author nik-lazer 03.12.2014   13:27
 */
public class DataUtil {
	public static List<Book> getBooks() {
		Book book1 = new Book();
		book1.setName("test1");
		book1.setAuthor("author1");
		book1.setPublisher("publisher1");
		book1.setLanguage("lang1");
		book1.setDesc("desc1");
		book1.setDate(new Date());

		Book book2 = new Book();
		book2.setName("test1");
		book2.setAuthor("author1");
		book2.setPublisher("publisher1");
		book2.setLanguage("lang1");
		book2.setDesc("desc1");
		book2.setDate(new Date());
		return Arrays.asList(book1, book2);
	}

	public static List<Language> getLanguages() {
		Language language1 = new Language();
		language1.setName("English");

		Language language2 = new Language();
		language2.setName("German");
		return Arrays.asList(language1, language2);
	}
}
