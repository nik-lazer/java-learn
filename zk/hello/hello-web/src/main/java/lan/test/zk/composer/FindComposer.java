package lan.test.zk.composer;

import lan.test.zk.au.PointerPopupAuResponse;
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
	}

	@Listen("onClick=#findButton")
	public void find() {
		Clients.showNotification("Hi", "error", editor, "after_start", 0);
	}

	@Listen("onClick=#findNextButton")
	public void findNext() {
		showPointerPopup(editor, "Attention!", "Find next button clicked!", "It's a second button", null);
	}

	private void showPointerPopup(Component component, String title, String msg, String desc, String type) {
		Execution exec = Executions.getCurrent();
		Page page = component != null ? component.getPage() : null;
		if (page == null && exec instanceof ExecutionCtrl)
			page = ((ExecutionCtrl) exec).getCurrentPage();
		if (type == null)
			type = Clients.NOTIFICATION_TYPE_INFO;
		Clients.response(new PointerPopupAuResponse(title, msg, desc, type, page, editor, "after_start", 0, false));
	}
}
