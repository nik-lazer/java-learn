package lan.test.zk;

import org.zkoss.bind.BindComposer;
import org.zkoss.web.theme.StandardTheme;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;
import org.zkoss.zul.theme.Themes;

/**
 * TODO: comment
 * @author lazarev_nv 06.06.2014   16:20
 */
public class IndexComposer extends SelectorComposer<Window> {
	@Wire
	Button switchTheme;
	@Wire
	Label currentTheme;

	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		currentTheme.setValue(Themes.getCurrentTheme());
	}

	@Listen("onClick=#switchTheme")
	public void switchTheme() {
		String theme = Themes.getCurrentTheme();
		if ("custom".equals(theme)) {
			Themes.setTheme(Executions.getCurrent(), StandardTheme.DEFAULT_NAME);
		} else {
			Themes.setTheme(Executions.getCurrent(), "custom");
		}
		Executions.sendRedirect("/");
	}
}
