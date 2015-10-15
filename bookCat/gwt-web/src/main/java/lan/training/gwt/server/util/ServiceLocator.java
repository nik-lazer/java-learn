package lan.training.gwt.server.util;

import lan.training.service.AuthorService;
import lan.training.service.BookService;
import lan.training.service.LanguageService;
import lan.training.service.PublisherService;
import org.springframework.context.ApplicationContext;

/**
 * Locator for linking GWT reomte services and Spring beans
 * @author nik-lazer  01.10.2015   13:37
 */
public class ServiceLocator {
	private static final ServiceLocator INSTANCE = new ServiceLocator();

	private ApplicationContext applicationContext;

	public static ServiceLocator instance() {
		return INSTANCE;
	}

	private ServiceLocator() {
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public Object getService(String id) {
		if (applicationContext == null) {
			return null;
		}
		return applicationContext.getBean(id);
	}

	public static BookService getBookService() {
		return (BookService) instance().getService("bookServiceImpl");
	}

	public static AuthorService getAuthorService() {
		return (AuthorService) instance().getService("authorServiceImpl");
	}

	public static PublisherService getPublisherService() {
		return (PublisherService) instance().getService("publisherServiceImpl");
	}

	public static LanguageService getLanguageService() {
		return (LanguageService) instance().getService("languageServiceImpl");
	}
}
