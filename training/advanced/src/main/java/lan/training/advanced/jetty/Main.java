package lan.training.advanced.jetty;

import lan.training.advanced.message.MessageSystem;
import org.eclipse.jetty.server.Server;

/**
 * Main method
 * @author nik-lazer  29.12.2014   12:53
 */
public class Main {
	public static void main(String[] args) throws Exception
	{
		Server server = new Server(8080);
		MessageSystem messageSystem = new MessageSystem();
		Frontend frontend = new Frontend(messageSystem);
		AccountService accountService = new AccountService(messageSystem);
		server.setHandler(frontend);
		new Thread(frontend).start();
		new Thread(accountService).start();
		//ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		//context.setContextPath("/servlets/");
		//server.setHandler(context);

		//context.addServlet(new ServletHolder(new FormServlet()), "/form/*");
		//context.addServlet(new ServletHolder(new CookieServlet()), "/cookie/*");

		server.start();
		server.join();
	}

}
