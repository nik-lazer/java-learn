package lan.test.zk.renderer;

import lan.test.zk.domain.Person;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

/**
 * Simple person renderer for {@link org.zkoss.zul.Listbox}
 * @author nik-lazer 28.10.2014   16:06
 */
public class PersonListItemSimpleRenderer implements ListitemRenderer<lan.test.zk.domain.Person> {
	public void render(Listitem item, Person data, int index) throws Exception {
		item.appendChild(new Listcell());
		addListcell(item, data.getName());
		addListcell(item, data.getSurname());
		addListcell(item, data.getAge()+"");
		addListcell(item, data.getAddress());
	}

	private void addListcell (Listitem listitem, String value) {
		Listcell lc = new Listcell ();
		Label lb = new Label(value);
		lb.setParent(lc);
		lc.setParent(listitem);
	}
}
