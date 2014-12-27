package lan.test.zk.util;

import org.zkoss.zk.ui.Executions;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Helper for working with cookies
 * @author nik-lazer  27.12.2014   13:42
 */
public class CookieUtil {
	public static void setCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		((HttpServletResponse) Executions.getCurrent().getNativeResponse()).addCookie(cookie);
	}

	public static String getCookie(String name) {
		Cookie[] cookies = ((HttpServletRequest) Executions.getCurrent().getNativeRequest()).getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
}
