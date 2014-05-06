package tree;

import model.Group;
import model.Student;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.TreeNode;
import org.zkoss.zul.event.TreeDataEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO: comment
 * @author lazarev_nv 06.05.2014   17:21
 */
public class GroupTreeNode implements TreeNode {
	private MainTreeNode rootTreeNode;
	private List<TreeNode> studentTreeNodes = new ArrayList<TreeNode>();
	private Group group;

	public GroupTreeNode(MainTreeNode rootNode,Group group) {
		this.rootTreeNode = rootNode;
		this.group = group;
		createChilds();
	}

	@Override
	public DefaultTreeModel getModel() {
		return rootTreeNode.getModel();
	}

	@Override
	public void setModel(DefaultTreeModel model) {
		rootTreeNode.setModel(model);
	}

	@Override
	public Object getData() {
		return getModel();
	}

	@Override
	public void setData(Object data) {

	}

	@Override
	public List<TreeNode> getChildren() {
		return studentTreeNodes;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return studentTreeNodes.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return studentTreeNodes.size();
	}

	@Override
	public TreeNode getParent() {
		return rootTreeNode;
	}

	@Override
	public int getIndex(TreeNode node) {
		return 0;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public void insert(TreeNode child, int index) {
		studentTreeNodes.add(index, child);
		getModel().fireEvent(TreeDataEvent.STRUCTURE_CHANGED, getModel().getPath(GroupTreeNode.this), index, studentTreeNodes.size() - 1);
	}

	@Override
	public void add(TreeNode child) {
		studentTreeNodes.add(child);
		final int idx = studentTreeNodes.size() - 1;
		if (getModel() != null) {
			getModel().fireEvent(TreeDataEvent.INTERVAL_ADDED, getModel().getPath(GroupTreeNode.this), idx, idx);
		}
	}

	@Override
	public void remove(int index) {
		studentTreeNodes.remove(index);
		getModel().fireEvent(TreeDataEvent.INTERVAL_REMOVED, getModel().getPath(GroupTreeNode.this), index, index);
	}

	@Override
	public void remove(TreeNode child) {
		int idx = studentTreeNodes.indexOf(child);
		remove(idx);

	}

	@Override
	public Object clone() {
		return this;
	}

	private void createChilds() {
		for (Student student: group.getStudents()) {
			TreeNode node = new StudentTreeNode(student);
			add(node);
		}
	}

	@Override
	public String toString() {
		return group.toString();
	}
}
