package tree;

import model.Group;
import model.Student;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Pobedyonny 25.02.2014
 */
public class MyTreeNode implements TreeNode{
	private Group group;
	private DefaultTreeModel model;
	private List<TreeNode> children;

	public MyTreeNode(Group group) {
		this.group = group;
	}

	public DefaultTreeModel getModel() {
		return model;
	}

	public void setModel(DefaultTreeModel model) {
		this.model = model;
	}

	public Object getData() {
		return group;
	}

	public void setData(Object data) {

	}

	public List<TreeNode> getChildren() {
		if(children == null) {
			children = new ArrayList<TreeNode>(group.getStudents().size());
		}
		for (Student student: group.getStudents()) {
			children.add(new DefaultTreeNode(student));
		}
		return children;
	}

	public TreeNode getChildAt(int childIndex) {
		return getChildren().get(childIndex);
	}

	public int getChildCount() {
		return group.getStudents().size();
	}

	public TreeNode getParent() {
		return null;
	}

	public int getIndex(TreeNode node) {
		return 0;
	}

	public boolean isLeaf() {
		return getChildCount() == 0;
	}

	public void insert(TreeNode child, int index) {

	}

	public void add(TreeNode child) {

	}

	public void remove(int index) {

	}

	public void remove(TreeNode child) {

	}

	@Override
	public Object clone() {
		return this;
	}
}
