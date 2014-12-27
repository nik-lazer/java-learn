package lan.training.advanced.jetty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * getting form data in servlet
 * @author nik-lazer  26.12.2014   12:52
 */
public class FormServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(FormServlet.class.getName());
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println(PageGenerator.createRefreshingFormPage(null));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		Integer id = PageGenerator.getId(param);
		if (id == null ) {
			id = PageGenerator.generateId();
			log.info("Id for form generated ="+id);
		}
		response.getWriter().println(PageGenerator.createRefreshingFormPage(id));
	}
}
