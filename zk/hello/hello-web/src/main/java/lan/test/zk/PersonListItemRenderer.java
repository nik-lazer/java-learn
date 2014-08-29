package lan.test.zk;

import lan.test.zk.domain.Person;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.ListitemRendererExt;
import org.zkoss.zul.Messagebox;

/**
 * Renderer for the listbox with stubonly cells
 * @author nik-lazer 25.08.2014   11:08
 */
public class PersonListItemRenderer implements ListitemRenderer<Person>, ListitemRendererExt {
	public void render(Listitem item, Person data, int index) throws Exception {
		item.setValue(data);

		if (item.getFirstChild() instanceof Listcell) {
			Listcell listcell = (Listcell) item.getFirstChild();
			addActionColumn(item, listcell);
		}
		addListcell(item, data.getName());
		addListcell(item, data.getSurname());
		addListcell(item, data.getAge()+"");
		addListcell(item, data.getGender().getTitle());
		addListcell(item, data.getAddress());
	}

	private void addListcell (Listitem listitem, String value) {
		Listcell lc = new Listcell ();
		Label lb = new Label(value);
		lb.setParent(lc);
		lc.setStubonly(true);
		lc.setParent(listitem);
	}

	private void addActionColumn(final Listitem item, Listcell cell) {
		Button nameButton = new Button("name");
		nameButton.addEventListener("onClick", new EventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				Person person = item.getValue();
				Messagebox.show("Person name - " + person.getName());
			}
		});
		nameButton.setParent(cell);
		Button helloButton = new Button("hello");
		helloButton.addEventListener("onClick", new EventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				Person person = item.getValue();
				Messagebox.show(person.getName() + " hello you!");
			}
		});
		helloButton.setParent(cell);
	}

	public Listitem newListitem(Listbox listbox) {
		Listitem listitem = new Listitem();
		return listitem;
	}

	public Listcell newListcell(Listitem item) {
		return null;
	}

	public int getControls() {
		return 0;
	}
}
