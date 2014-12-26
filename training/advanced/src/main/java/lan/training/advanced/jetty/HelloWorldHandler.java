package lan.training.advanced.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Abstarct handler uding sample
 * @author nik-lazer  26.12.2014   11:41
 */
public class HelloWorldHandler extends AbstractHandler {
	@Override
	public void handle(String s, Request request, HttpServletRequest request2, HttpServletResponse response) throws IOException, ServletException {
		String param = request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		request.setHandled(true);
		response.getWriter().println(PageGenerator.createRefreshingFormPage(PageGenerator.getId(param)));
	}

	public static void main(String[] args) throws Exception
	{
		Server server = new Server(8080);
		server.setHandler(new HelloWorldHandler());
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);

		context.addServlet(new ServletHolder(new FormServlet()), "/servlets/form/*");
		context.addServlet(new ServletHolder(new CookieServlet()), "/servlets/cookie/*");

		server.start();
		server.join();
	}
}
