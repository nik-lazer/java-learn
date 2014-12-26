package lan.training.advanced.jetty;

import java.util.Random;

/**
 * Util class for generation html
 * @author nik-lazer  26.12.2014   11:50
 */
public class PageGenerator {
	public static String createRefreshingFormPage(Integer id) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<html>");
		stringBuilder.append("<head><title>Refreshable page</title></head>");
		stringBuilder.append("<body>");
		stringBuilder.append("<div>Hello world!</div>");
		stringBuilder.append("<form id='form' method='POST'>");
		stringBuilder.append("<input type='hidden' name='id' value='"+(id!=null?id:"")+"'>");
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
