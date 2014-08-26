package lan.test.zk;

import lan.test.zk.domain.Gender;
import lan.test.zk.domain.Person;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;

import java.util.Arrays;
import java.util.List;

/**
 * TODO: comment
 * @author lazarev.nikolay 25.08.2014   10:27
 */
public class StubOnlyComposer extends SelectorComposer<Window> {
	@Wire
	private Listbox table;

	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		final ListModelList tableModel = new ListModelList(getColumns());
		table.setModel(tableModel);
		table.setItemRenderer(new PersonListItemRenderer());
	}

	private List<Person> getColumns() {
		return Arrays.asList(
			new Person("Peter", "Smith", 27, Gender.MALE, "Newcastle, Oak street, 56"),
			new Person("Jane", "Poridge", 25, Gender.FEMALE, "London, Harley street, 12"),
			new Person("James", "Watson", 33, Gender.MALE, "Berkley street, 15"),
			new Person("Sherlok", "Holms", 35, Gender.MALE, "Berkley street, 15"),
			new Person("Thomas", "Tailor", 45, Gender.MALE, "New-York, Broadway street, 100"),
			new Person("Samanta", "Smith", 21, Gender.FEMALE, "York, Yew street, 135"),
			new Person("Fred", "Newman", 54, Gender.MALE, "London, 6 Avenue, 29")
		);
	}
}
