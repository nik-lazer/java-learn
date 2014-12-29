package lan.training.advanced.servlet;

import lan.training.advanced.jetty.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Getting cookies in servlet
 * @author nik-lazer  26.12.2014   13:07
 */
public class CookieServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(CookieServlet.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] coookies = request.getCookies();
		String param = null;
		if (coookies != null) {
			for (int i = 0; i < coookies.length; i++) {
				if ("id".equals(coookies[i].getName())) {
					param = coookies[i].getValue();
					break;
				}
			}
		}
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		Integer id = PageGenerator.getId(param);
		if (id == null) {
			id = PageGenerator.generateId();
			log.info("Id for cookie generated ="+id);
			Cookie cookie = new Cookie("id", id.toString());
			response.addCookie(cookie);
		}
		response.getWriter().println(PageGenerator.createRefreshingCookiePage(id));
	}

}
