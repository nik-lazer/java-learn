package lan.test.zk.composer;

import lan.test.zk.component.ColoredListbox;
import lan.test.zk.renderer.PersonListItemRenderer;
import lan.test.zk.model.RefreshableListModel;
import lan.test.zk.util.DataUtil;
import lan.test.zk.domain.Gender;
import lan.test.zk.domain.Person;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;
import org.zkoss.zul.event.ListDataEvent;
import org.zkoss.zul.event.ListDataListener;
import org.zkoss.zul.ext.Selectable;

/**
 * Composer for the testing table with stubonly cells
 * @author nik-lazer 25.08.2014   10:27
 */
public class StubOnlyComposer extends SelectorComposer<Window> {
	@Wire
	private Listbox table;
	@Wire
	private Button refreshButton;
	@Wire
	private Button addButton;
	@Wire
	private Button reattachButton;
	@Wire
	private Center center;

	public void doAfterCompose(final Window comp) throws Exception {
		super.doAfterCompose(comp);
		final RefreshableListModel tableModel = new RefreshableListModel(DataUtil.getPersons());
		table.setModel(tableModel);
		table.setMold("paging");
		table.setPageSize(5);
		table.setItemRenderer(new PersonListItemRenderer());
		refreshButton.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				tableModel.refresh();
			}
		});
		addButton.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				Person person = new Person("Debora", "Raily", 32, Gender.FEMALE, "Newcastle, Oak street, 26");
				tableModel.add(person);
			}
		});
		reattachButton.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				center.removeChild(table);
				center.appendChild(table);
			}
		});
	}
}
