package lan.test.zk.composer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Window;

/**
 * Tabbox dynamic changing example
 * @author nik-lazer  20.11.2015   16:45
 */
public class TabboxComposer extends SelectorComposer<Window> {
	@Wire
	private Tabbox tabbox;
	@Wire
	private Button newButton;
	@Wire
	private Button sameButton;

	@Override
	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		newButton.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				Tab tab = new Tab("new");
				Tabpanel tabpanel = new Tabpanel();
				Component component = Executions.createComponents("/form.zul", null, null);
				tabpanel.appendChild(component);
				tabbox.getTabs().appendChild(tab);
				tabbox.getTabpanels().appendChild(tabpanel);
				tabbox.setSelectedTab(tab);
			}
		});
	}
}
