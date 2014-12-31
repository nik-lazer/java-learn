package lan.test.zk.composer;

import lan.test.zk.domain.Food;
import lan.test.zk.model.FoodGroupsModel;
import lan.test.zk.renderer.FoodGroupRenderer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.Grid;

/**
 * Food composer from zkoss examples
 * @author nik-lazer  31.12.2014   13:41
 */
public class FoodComposer implements Composer {
	Food[] _foods = new Food[] { //assume we have a collection of foods
			new Food("Vegetables", "Asparagus", "Vitamin K", 115, 43),
			new Food("Vegetables", "Beets", "Folate", 33, 74)
			//...more
	};

	public void doAfterCompose(Component comp) throws Exception {
		Grid grid = (Grid)comp;
		grid.setModel(new FoodGroupsModel(_foods));
		//Initially, we group data on 1st column in ascending order
		grid.setRowRenderer(new FoodGroupRenderer());
	}
}
