package lan.test.zk;

import lan.test.zk.data.DataUtil;
import lan.test.zk.domain.Person;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;

import java.util.Set;

/**
 * Composer for person.zul
 * @author nik-lazer 28.10.2014   16:08
 */
public class ListboxPersonComposer extends SelectorComposer<Window> {
	@Wire
	private Listbox table;
	@Wire
	private Button selButton;

	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		final ListModelList tableModel = new ListModelList();
		tableModel.setMultiple(true);
		tableModel.addAll(DataUtil.getPersons());
		table.setModel(tableModel);
		table.setItemRenderer(new PersonListItemSimpleRenderer());
		selButton.addEventListener("onClick", new EventListener<Event>() {
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
	}
}
