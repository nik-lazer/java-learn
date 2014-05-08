package tree;

import model.Student;
import org.zkoss.zul.Label;
import org.zkoss.zul.TreeNode;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;

/**
 * Custom renderer for tree
 * @author lazarev_nv 07.05.2014   10:40
 */
public class CustomTreeRenderer implements TreeitemRenderer {
	@Override
	public void render(Treeitem item, Object data, int index) throws Exception {
		Treerow row = new Treerow();
		final Treecell cell = new Treecell();
		row.appendChild(cell);
		if(data instanceof TreeNode) {
			final Label child = new Label(data.toString());
			cell.appendChild(child);
			if (data instanceof StudentTreeNode) {
				if (((StudentTreeNode) data).isInCouncil()) {
					child.setStyle("font-weight: bold;");
				}
			}
			cell.appendChild(child);
		} else if(data instanceof Student) {
			cell.appendChild(new Label(((Student) data).getName()));
		}
		item.appendChild(row);
	}
}
