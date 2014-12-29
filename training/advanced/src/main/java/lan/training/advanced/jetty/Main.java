package lan.training.advanced.jetty;

import lan.training.advanced.account.AccountServiceImpl;
import lan.training.advanced.frontend.FrontendImpl;
import lan.training.advanced.message.MessageSystem;
import lan.training.advanced.message.MessageSystemImpl;
import org.eclipse.jetty.server.Server;

/**
 * Main method
 * @author nik-lazer  29.12.2014   12:53
 */
public class Main {
	public static void main(String[] args) throws Exception
	{
		Server server = new Server(8080);
		MessageSystem messageSystem = new MessageSystemImpl();
		AccountServiceImpl accountService = new AccountServiceImpl(messageSystem);
		FrontendImpl frontend = new FrontendImpl(messageSystem, accountService.getAddress());
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
