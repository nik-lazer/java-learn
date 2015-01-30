package lan.test.zk.composer;

import org.zkoss.web.fn.ServletFns;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;

/**
 * Composer for the search dialog
 * @author nik-lazer  19.12.2014   13:21
 */
public class FindComposer extends SelectorComposer<Window> {
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
}
