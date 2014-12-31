package lan.test.zk.model;

import lan.test.zk.domain.Food;
import org.zkoss.zul.FieldComparator;
import org.zkoss.zul.GroupsModelArray;

/**
 * Food groups model from zkoss examples
 * @author nik-lazer  31.12.2014   13:39
 */
public class FoodGroupsModel extends GroupsModelArray {
	public FoodGroupsModel(Food[] foods) {
		super(foods, new FieldComparator("category", true));
	}
	protected Object createGroupHead(Object[] groupdata,int index,int col) {
		return new Object[] {groupdata[0], new Integer(col)};
	}

	@Override
	public boolean isGroupOpened(int groupIndex) {
		return super.isGroupOpened(groupIndex);
	}
};

