package lan.test.zk.composer;

import lan.test.zk.util.DataUtil;
import lan.test.zk.domain.Person;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import java.util.List;
import java.util.Random;

/**
 * Dialog composer
 * @author nik-lazer  17.12.2014   17:28
 */
public class DialogComposer extends SelectorComposer<Window> {
	@Wire
	Button closeButton;
	@Wire
	Button addrowButton;
	@Wire
	Grid grid;
	@Wire
	Textbox textBox;
	@Wire
	Textbox textBoxReadonly;
	@Wire
	Textbox textBoxDisabled;

	ListModelList<Person> listModel = new ListModelList<Person>();

	@Override
	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		grid.setModel(listModel);
		grid.setRowRenderer(new RowRenderer<Person>() {
			public void render(Row row, Person data, int index) throws Exception {
				Cell cell1 = new Cell();
				cell1.appendChild(new Label(data.getName()));
				Cell cell2 = new Cell();
				cell2.appendChild(new Label(data.getSurname()));
				row.appendChild(cell1);
				row.appendChild(cell2);
			}
		});
	}

	@Listen("onClick=#closeButton")
	public void closeWindow() {
		getSelf().onClose();
	}

	@Listen("onClick=#addRowButton")
	public void addRow() {
		putRandomDataToModel();
	}

	@Listen("onClick=#simpleButton")
	public void simpleClick() {
		textBox.setValue(textBox.getValue() + "clicked");
	}

	@Listen("onClick=#readonlyButton")
	public void readonlyClick() {
		textBoxReadonly.setValue(textBoxReadonly.getValue() + "clicked");
	}

	@Listen("onClick=#disabledButton")
	public void disabledClick() {
		textBoxDisabled.setValue(textBoxDisabled.getValue() + "clicked");
	}

	private void putRandomDataToModel() {
		List<Person> list = DataUtil.getPersons();
		Random random = new Random();
		int index = random.nextInt(list.size()-1);
		listModel.add(list.get(index));
	}
}
