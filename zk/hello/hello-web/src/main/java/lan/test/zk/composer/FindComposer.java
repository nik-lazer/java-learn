package lan.test.zk.composer;

import lan.test.zk.au.PointerPopupAuResponse;
import lan.test.zk.constraint.PopupNoEmptyConstraint;
import org.zkoss.web.fn.ServletFns;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.sys.ExecutionCtrl;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 * Composer for the search dialog
 * @author nik-lazer  19.12.2014   13:21
 */
public class FindComposer extends SelectorComposer<Window> {
	@Wire
	Textbox editor;
	@Wire
	private Button findButton;
	@Wire
	private Button findNextButton;
	@Wire
	private Button cancelButton;

	@Override
	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		findButton.setImage(ServletFns.resolveThemeURL("~./find.png"));
		findNextButton.setImage(ServletFns.resolveThemeURL("~./find_next.png"));
		cancelButton.setImage(ServletFns.resolveThemeURL("~./exit.png"));
		editor.setConstraint(new PopupNoEmptyConstraint());
	}

	@Listen("onClick=#findButton")
	public void find() {
		Clients.showNotification("Hi", "error", editor, "after_start", 0);
	}

	@Listen("onClick=#findNextButton")
	public void findNext() {
		editor.getValue();
	}
}
