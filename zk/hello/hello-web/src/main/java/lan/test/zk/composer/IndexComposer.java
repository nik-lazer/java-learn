package lan.test.zk.composer;

import com.google.common.collect.FluentIterable;
import lan.test.zk.domain.Contributor;
import lan.test.zk.model.RefreshableListModel;
import lan.test.zk.renderer.ContributorRenderer;
import lan.test.zk.util.DataUtil;
import org.zkoss.bind.BindComposer;
import org.zkoss.web.theme.StandardTheme;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;
import org.zkoss.zul.impl.MessageboxDlg;
import org.zkoss.zul.theme.Themes;

import java.util.Collection;

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
	@Wire
	Button updateModel;
	@Wire
	Button errorButton;
	@Wire
	Grid grid;
	RefreshableListModel<Contributor> model;


	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		Executions.getCurrent().getDesktop().enableServerPush(true);
		currentTheme.setValue(Themes.getCurrentTheme());
		model = new RefreshableListModel<Contributor>(DataUtil.getContributors());
		grid.setModel(model);
		grid.setRowRenderer(new ContributorRenderer());
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

	@Listen("onClick=#errorButton")
	public void openPeoppleWindow() {
		Window window = (Window)Executions.createComponents("/frameWithError.zul", null, null);
		window.doModal();
		highlightErrorMsgBoxes(window);
	}

	@Listen("onClick=#updateModel")
	public void updateModel() {
		model.updateData(DataUtil.getContributors());
	}

	/**
	 * Change parent for rendered before messages
	 * @param overlappedWindow
	 */
	private void highlightErrorMsgBoxes(Window overlappedWindow) {
		Collection<Component> roots = overlappedWindow.getPage().getRoots();
		FluentIterable<MessageboxDlg> errorMsgBoxIterable = FluentIterable.from(roots).filter(MessageboxDlg.class);
		for (MessageboxDlg zkossErrorMsgBox : errorMsgBoxIterable) {
			zkossErrorMsgBox.setParent(overlappedWindow);
		}
	}

}
