package lan.training.memory.util;

import lan.training.core.factory.AuthorFactory;
import lan.training.core.factory.BookFactory;
import lan.training.core.factory.LanguageFactory;
import lan.training.core.factory.PublisherFactory;
import lan.training.core.model.Author;
import lan.training.core.model.Book;
import lan.training.core.model.Language;
import lan.training.core.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Utilitary functions
 * @author nik-lazer 03.12.2014   13:27
 */
@Component
public class DataUtilBean {
	@Autowired
	BookFactory bookFactory;
	@Autowired
	LanguageFactory languageFactory;
	@Autowired
	AuthorFactory authorFactory;
	@Autowired
	PublisherFactory publisherFactory;
	private static Random random = new Random();

	public List<Book> getBooks() {
		Book book1 = bookFactory.of(random.nextInt(), "test1", getPublishers().get(0), getAuthors().get(0), getLanguages().get(0), new Date(), "desc1");
		Book book2 = bookFactory.of(random.nextInt(), "test1", getPublishers().get(0), getAuthors().get(0), getLanguages().get(0), new Date(), "desc1");
		return Arrays.asList(book1, book2);
	}

	public List<Language> getLanguages() {
		Language language1 = languageFactory.of(random.nextInt(), "English");
		Language language2 = languageFactory.of(random.nextInt(), "German");
		return Arrays.asList(language1, language2);
	}

	public List<Author> getAuthors() {
		Author author1 = authorFactory.of(random.nextInt(), "Craig", "Walls");
		Author author2 = authorFactory.of(random.nextInt(), "Gerbert", "Wales");
		return Arrays.asList(author1, author2);
	}

	public List<Publisher> getPublishers() {
		Publisher publisher1 = publisherFactory.of(random.nextInt(), "O'Reily", null);
		Publisher publisher2 = publisherFactory.of(random.nextInt(), "BBC", null);
		return Arrays.asList(publisher1, publisher2);
	}


}
