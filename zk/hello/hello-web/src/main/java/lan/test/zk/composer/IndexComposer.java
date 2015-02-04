package lan.test.zk.composer;

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
 * Composer for main page
 * @author nik-lazer 06.06.2014   16:20
 */
public class IndexComposer extends SelectorComposer<Window> {
	@Wire
	Button switchTheme;
	@Wire
	Label currentTheme;
	@Wire
	Button openDialog;
	@Wire
	Button openFindDialog;
	@Wire
	Button openGroupBoxdialog;

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

	@Listen("onClick=#openDialog")
	public void openDialog() {
		Window window = (Window)Executions.createComponents("/dialog.zul", null, null);
		window.doModal();
	}

	@Listen("onClick=#errorDialog")
	public void openErrorDialog() {
		Window window = (Window)Executions.createComponents("/errorDialog.zul", null, null);
		window.doModal();
	}

	@Listen("onClick=#openFindDialog")
	public void openFindDialog() {
		Window window = (Window)Executions.createComponents("/find.zul", null, null);
		window.doModal();
	}

	@Listen("onClick=#openGroupBoxDialog")
	public void openGroupboxDialog() {
		Window window = (Window)Executions.createComponents("/groupbox.zul", null, null);
		window.doModal();
	}

}
