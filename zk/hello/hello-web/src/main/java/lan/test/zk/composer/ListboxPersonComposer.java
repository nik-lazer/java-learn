package lan.test.zk.composer;

import lan.test.zk.component.IteratorListbox;
import lan.test.zk.event.IteratorSizeEvent;
import lan.test.zk.renderer.PersonListItemSimpleRenderer;
import lan.test.zk.util.DataUtil;
import lan.test.zk.domain.Person;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Window;

import java.util.Set;

/**
 * Composer for person.zul
 * @author nik-lazer 28.10.2014   16:08
 */
public class ListboxPersonComposer extends SelectorComposer<Window> {
	@Wire
	private IteratorListbox table;
	@Wire
	private Button selButton;
	@Wire
	private Button disableNameButton;
	@Wire
	private Button disableAgeButton;
	@Wire
	private Listheader nameColumn;
	@Wire
	private Listheader ageColumn;
	@Wire
	private Hbox toolbar;

	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		final ListModelList tableModel = new ListModelList();
		tableModel.setMultiple(true);
		tableModel.addAll(DataUtil.getPersons());
		table.setModel(tableModel);
		table.setItemRenderer(new PersonListItemSimpleRenderer());
		selButton.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				Set<Person> set = tableModel.getSelection();
				if (set.size()>0) {
					StringBuffer buffer = new StringBuffer();
					for (Person person : set) {
						if (buffer.length()>0) {
							buffer.append(", ");
						}
						buffer.append(person.getName() + "(index "+tableModel.indexOf(person)+")");
					}
					Clients.showNotification("Selected persons are: " + buffer.toString());
				} else {
					Clients.showNotification("Selection is empty");
				}
			}
		});
		table.addEventListener(IteratorSizeEvent.NAME, new SerializableEventListener<IteratorSizeEvent>() {
			public void onEvent(IteratorSizeEvent event) throws Exception {
				toolbar.setWidth(event.getWidth());
				toolbar.invalidate();
			}
		});
	}

	@Listen("onClick=#disableNameButton")
	public void disableNameColumn() {
		if (nameColumn.isVisible()) {
			nameColumn.setVisible(false);
			disableNameButton.setLabel("Enable name");
		} else {
			nameColumn.setVisible(true);
			disableNameButton.setLabel("Disable name");
		}
	}

	@Listen("onClick=#disableAgeButton")
	public void disableAgeColumn() {
		if (ageColumn.isVisible()) {
			ageColumn.setVisible(false);
			disableAgeButton.setLabel("Enable age");
		} else {
			ageColumn.setVisible(true);
			disableAgeButton.setLabel("Disable age");
		}
	}
}
