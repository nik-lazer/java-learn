package lan.training.advanced.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

/**
 * Abstarct handler uding sample
 * @author nik-lazer  26.12.2014   11:41
 */
public class Frontend extends AbstractHandler implements Runnable {
	private static Logger log = Logger.getLogger(Frontend.class.getName());

	private volatile int handleCount = 0;

	@Override
	public void handle(String s, Request request, HttpServletRequest request2, HttpServletResponse response) throws IOException, ServletException {
		String param = request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		request.setHandled(true);
		Integer id = PageGenerator.getId(param);
		if (id == null ) {
			id = PageGenerator.generateId();
		}
		incCounter();
		response.getWriter().println(PageGenerator.createRefreshingFormPage(id));
	}

	public static void main(String[] args) throws Exception
	{
		Server server = new Server(8080);
		Frontend frontend = new Frontend();
		server.setHandler(frontend);
		new Thread(frontend).start();
		//ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		//context.setContextPath("/servlets/");
		//server.setHandler(context);

		//context.addServlet(new ServletHolder(new FormServlet()), "/form/*");
		//context.addServlet(new ServletHolder(new CookieServlet()), "/cookie/*");

		server.start();
		server.join();
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(5000);
				log.info("handleCount=" + handleCount);
			} catch (InterruptedException e) {
				log.log(Level.WARNING, "Frontend was interrupted", e);
				e.printStackTrace();
			}
		}
	}

	private synchronized void incCounter() {
		handleCount++;
		log.info("handleCount increment: old val=" + (handleCount - 1) + ", new value=" + handleCount);
	}
}
