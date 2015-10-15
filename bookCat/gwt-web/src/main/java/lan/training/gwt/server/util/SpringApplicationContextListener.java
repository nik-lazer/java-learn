package lan.training.gwt.server.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Listener for ServiceLocator initialization
 * @author nik-lazer  01.10.2015   13:41
 */
public class SpringApplicationContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		ServiceLocator.instance().setApplicationContext(applicationContext);
	}

	public void contextDestroyed(ServletContextEvent event) {
	}

}
