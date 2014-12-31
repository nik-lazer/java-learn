package lan.test.zk.renderer;

import lan.test.zk.domain.Gender;
import lan.test.zk.domain.Person;
import org.zkoss.zul.Button;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Group;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

/**
 * Person group renderer
 * @author nik-lazer  30.12.2014   18:05
 */
public class PersonGroupsRenderer implements RowRenderer {
	public void render(Row row, Object data, int index) throws Exception {
		//if (row instanceof Group) {
		if (data instanceof Gender) {
			//display the group head
			Gender gender = (Gender)data;
			Cell cell = new Cell();
			final Label groupLabel = new Label(gender.getTitle());
			groupLabel.setStyle("font-weight: bold;");
			cell.appendChild(groupLabel);
			row.appendChild(cell);
			cell = createButtons(gender, null);
			row.appendChild(cell);
			row.getGroup().setValue(data);
			row.setStyle("background-color: #E5E5E5;");
			row.getGroup().setValue(data);
		} else {
			//display an element
			Person person = (Person)data;
			row.appendChild(new Label(person.getName()));
			row.appendChild(new Label(person.getSurname()));
			row.appendChild(new Label(person.getAddress()));
			row.appendChild(new Label(""+person.getAge()));
		}
	}

	private Cell createButtons(Gender data, Object o) {
		Cell cell = new Cell();
		cell.setSclass("z-cell-noborder");
		cell.setAlign("center");
		Button firstButton = new Button("Button 1");
		Button secondButton = new Button("Button 2");
		cell.appendChild(firstButton);
		cell.appendChild(secondButton);
		return cell;
	}
}
