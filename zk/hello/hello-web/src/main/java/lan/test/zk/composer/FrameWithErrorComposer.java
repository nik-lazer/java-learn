package lan.test.zk.composer;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 * Create message box on render phase
 * @author nik-lazer  22.05.2015   09:04
 */
public class FrameWithErrorComposer extends SelectorComposer<Window> {
	@Override
	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		showError();
	}

	private void showError() {
		Messagebox.show("Error", "Operation completion error", Messagebox.OK, Messagebox.ERROR);
	}
}
