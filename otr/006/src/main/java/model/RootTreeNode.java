package model;

import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.TreeNode;
import org.zkoss.zul.event.TreeDataEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Pobedyonny 25.02.2014
 */
public class RootTreeNode implements TreeNode{
	public List<Group> model;
	private DefaultTreeModel<? extends Object> treeModel;
	private List<TreeNode> groupNodes;

	public RootTreeNode(List<Group> model) {
		this.model = model;
	}

	public DefaultTreeModel getModel() {
		return treeModel;
	}

	public void setModel(DefaultTreeModel model) {
		treeModel = model;
	}

	public Object getData() {
		return model;
	}

	public void setData(Object data) {

	}

	public List<TreeNode> getChildren() {
		return groupNodes;
	}

	public TreeNode getChildAt(int childIndex) {
		return groupNodes.get(childIndex);
	}

	public int getChildCount() {
		createChildNodes();
		return groupNodes.size();
	}

	private void createChildNodes() {
		groupNodes = new ArrayList<TreeNode>();
		for (Group group : model) {
//			groupNodes.add(new GroupTreeNode(group));
			ArrayList<TreeNode<String>> _children = new ArrayList<TreeNode<String>>();
			for (Student student : group.getStudents()) {
				_children.add(new DefaultTreeNode<String>(student.getName()));
			}
			groupNodes.add(new DefaultTreeNode(group, _children));
		}
	}

	public TreeNode getParent() {
		return null;
	}

	public int getIndex(TreeNode node) {
		return groupNodes.indexOf(node);
	}

	public boolean isLeaf() {
		return false;
	}

	public void insert(TreeNode child, int index) {

	}

	public void add(TreeNode child) {
		groupNodes.add(child);
		final int idx = groupNodes.size() - 1;
		treeModel.fireEvent(TreeDataEvent.INTERVAL_ADDED,
				treeModel.getPath(RootTreeNode.this), idx, idx);

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
