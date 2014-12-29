package lan.training.advanced.jetty;

import lan.training.advanced.frontend.UserSession;

import java.util.Random;

/**
 * Util class for generation html
 * @author nik-lazer  26.12.2014   11:50
 */
public class PageGenerator {
	public static String createRefreshingFormPage(int id) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<html>");
		stringBuilder.append("<head><title>Refreshable page</title></head>");
		stringBuilder.append("<body>");
		stringBuilder.append("<div>Hello world!</div>");
		stringBuilder.append("<form id='form' method='POST'>");
		stringBuilder.append("<input type='hidden' name='id' value='"+(id!=0?id:"")+"'>");
		stringBuilder.append("<div>Hello user! Your sessionId: "+id+"</div>");
		stringBuilder.append("<script>setInterval('document.getElementById(\"form\").submit()', 1000);</script>");
		stringBuilder.append("</form>");
		stringBuilder.append("</body>");
		stringBuilder.append("</html>");
		return stringBuilder.toString();
	}

	public static String createRefreshingCookiePage(Integer id) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<html>").append('\n');
		stringBuilder.append("<head>").append('\n');
		stringBuilder.append("<title>Refreshable page</title>").append('\n');
		stringBuilder.append("</head>").append('\n');
		stringBuilder.append("<body>").append('\n');
		stringBuilder.append("<div>Hello world!</div>").append('\n');
		stringBuilder.append("<div>Hello user! Your sessionId: "+id+"</div>").append('\n');
		stringBuilder.append("<script>setInterval('window.location.reload()', 1000);</script>").append('\n');
		stringBuilder.append("</body>").append('\n');
		stringBuilder.append("</html>").append('\n');
		return stringBuilder.toString();
	}

	public static String createRefreshingFormPage(UserSession userSession) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<html>");
		stringBuilder.append("<head><title>Input name page</title></head>");
		stringBuilder.append("<body>");
		stringBuilder.append("<div>Hello world!</div>");
		stringBuilder.append("<div>Hello user! Your sessionId: "+userSession.getSessionId()+"</div>");
		stringBuilder.append("<form id='form' method='POST'>");
		stringBuilder.append("<input type='hidden' name='id' value='"+(userSession.getSessionId() != 0 ? userSession.getSessionId() : "")+"'/>");
		boolean needInputName = (userSession.getUserName() == null) || (userSession.getUserName().isEmpty());
		if (needInputName) {
			stringBuilder.append("<div>Input your name:");
			stringBuilder.append("<input type='text' name='name' value=''/></div>");
			stringBuilder.append("<input type='submit'/>");
		} else if (userSession.getUserId() != 0) {
			stringBuilder.append("<div>");
			stringBuilder.append("Your name:" + userSession.getUserName());
			stringBuilder.append(", id:" + userSession.getUserId());
			stringBuilder.append("</div>");
			} else {
				stringBuilder.append("<div>Authorization waiting</div>");
			}
		if (!needInputName) {
			stringBuilder.append("<script>setInterval('document.getElementById(\"form\").submit()', 1000);</script>");
		}
		stringBuilder.append("</form>");
		stringBuilder.append("</body>");
		stringBuilder.append("</html>");
		return stringBuilder.toString();
	}


	public static Integer getId(String param) {
		Integer id = null;
		if (param != null) {
			try {
				id = Integer.parseInt(param);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return id;
	}

	public static Integer generateId() {
		Random random = new Random();
		return  random.nextInt();
	}
}
