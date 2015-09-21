package lan.training.util;

import lan.training.model.Author;
import lan.training.model.Book;
import lan.training.model.Language;
import lan.training.model.Publisher;

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
		book1.setAuthor(getAuthors().get(0));
		book1.setPublisher(getPublishers().get(0));
		book1.setLanguage(getLanguages().get(0));
		book1.setDesc("desc1");
		book1.setDate(new Date());

		Book book2 = new Book();
		book2.setName("test1");
		book2.setAuthor(getAuthors().get(0));
		book2.setPublisher(getPublishers().get(0));
		book2.setLanguage(getLanguages().get(0));
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

	public static List<Author> getAuthors() {
		Author author1 = new Author();
		author1.setFirstName("Craig");
		author1.setLastName("Walls");

		Author author2 = new Author();
		author2.setFirstName("Gerbert");
		author2.setLastName("Wales");
		return Arrays.asList(author1, author2);
	}

	public static List<Publisher> getPublishers() {
		Publisher publisher1 = new Publisher();
		publisher1.setName("O'Reily");

		Publisher publisher2 = new Publisher();
		publisher2.setName("BBC");
		return Arrays.asList(publisher1, publisher2);
	}


}
