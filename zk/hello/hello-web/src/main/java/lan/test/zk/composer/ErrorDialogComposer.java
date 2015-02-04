package lan.test.zk.composer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.web.fn.ServletFns;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

/**
 * composer for error dialog
 * @author nik-lazer 04.02.2015   21.55
 */
public class ErrorDialogComposer extends SelectorComposer<Window> {
	@Wire
	private Label titleText;
	@Wire
	private Image titleImage;
	@Wire
	private Label errorText;
	@Wire
	private Label descriptionText;
	private static final Log log = LogFactory.getLog(ErrorDialogComposer.class);

	@Override
	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		titleImage.setSrc(ServletFns.encodeThemeURL("~./stop-btn.png"));
	}

	public void setTitleText(String title) {
		titleText.setValue(title);
	}

	public void setErrorText(String text) {
		errorText.setValue(text);
	}

	public void setDescriptionText(String text) {
		descriptionText.setValue(text);
	}
}
