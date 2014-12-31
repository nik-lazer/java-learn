package lan.test.zk.renderer;

import lan.test.zk.domain.Food;
import org.zkoss.lang.reflect.Fields;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zul.Column;
import org.zkoss.zul.FieldComparator;
import org.zkoss.zul.Group;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

/**
 * Food group renderer from zkoss examples
 * @author nik-lazer  31.12.2014   13:40
 */
public class FoodGroupRenderer implements RowRenderer {
	public void render(Row row, java.lang.Object obj, int index) {
		if (row instanceof Group) {
			Object[] data = (Object[])obj; //prepared by createGroupHead()
			row.appendChild(new Label(getGroupHead(row, (Food)data[0], (Integer)data[1])));
		} else {
			Food food = (Food) obj;
			row.appendChild(new Label(food.getCategory()));
			row.appendChild(new Label(food.getName()));
			row.appendChild(new Label(food.getNutrients()));
			row.appendChild(new Label(food.getPercentageOfDaily() + ""));
			row.appendChild(new Label(food.getCalories() + ""));
		}
	}
	private String getGroupHead(Row row, Food food, int index) {
		Column column = (Column)row.getGrid().getColumns().getChildren().get(index);
		String orderBy = ((FieldComparator)column.getSortAscending()).getOrderBy();
		int j = orderBy.indexOf("name="),
				k = orderBy.indexOf(' ');
		try {
			return Fields.get(food, orderBy.substring(j + 1, k > 0 ? k : orderBy.length())).toString();
		} catch (NoSuchMethodException ex) {
			throw UiException.Aide.wrap(ex);
		}
	}
}
