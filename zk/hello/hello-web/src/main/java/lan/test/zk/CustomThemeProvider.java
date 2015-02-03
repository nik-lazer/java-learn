package lan.test.zk;

import org.zkoss.web.fn.ServletFns;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.util.ThemeProvider;
import org.zkoss.zul.theme.Themes;

import java.util.Collection;
import java.util.List;

/**
 * Customized theme provider
 * @author nik-lazer 23.05.2014   16:37
 */
public class CustomThemeProvider implements ThemeProvider {
	public Collection<Object> getThemeURIs(Execution execution, List<Object> objects) {
		if ("custom".equals(Themes.getCurrentTheme())) {
			objects.add("~./custom/override.custom.css.dsp");
		}
		return objects;
	}

	public int getWCSCacheControl(Execution execution, String s) {
		return -1;
	}

	public String beforeWCS(Execution execution, String s) {
		return s;
	}

	public String beforeWidgetCSS(Execution execution, String uri) {
		if (uri.startsWith("~./zul/css/") ||
		    uri.startsWith("~./js/lan/") ||
		    uri.startsWith("~./js/zul/")) {
			uri = ServletFns.resolveThemeURL(uri);
		}
		return uri;
	}
}
