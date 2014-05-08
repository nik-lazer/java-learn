package tree;

import model.Group;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.TreeNode;
import org.zkoss.zul.event.TreeDataEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Root tree node
 * @author lazarev_nv 06.05.2014   17:25
 */
public class MainTreeNode implements TreeNode {
	private DefaultTreeModel model;
	private List<TreeNode> groupTreeNodes = new ArrayList<TreeNode>();
	private List<Group> groups = new ArrayList<Group>();

	public MainTreeNode() {
	}

	public void setGroups(List<Group> groupList) {
		this.groups = groupList;
		createChilds();
	}

	@Override
	public DefaultTreeModel getModel() {
		return model;
	}

	@Override
	public void setModel(DefaultTreeModel model) {
		this.model = model;
	}

	@Override
	public Object getData() {
		return model;
	}

	@Override
	public void setData(Object data) {

	}

	@Override
	public List<TreeNode> getChildren() {
		return groupTreeNodes;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return groupTreeNodes.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return groupTreeNodes.size();
	}

	@Override
	public TreeNode getParent() {
		return null;
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
		groupTreeNodes.add(index, child);
		model.fireEvent(TreeDataEvent.STRUCTURE_CHANGED, model.getPath(MainTreeNode.this), index, groupTreeNodes.size() - 1);
	}

	@Override
	public void add(TreeNode child) {
		groupTreeNodes.add(child);
		final int idx = groupTreeNodes.size() - 1;
		if (model!=null) {
			model.fireEvent(TreeDataEvent.INTERVAL_ADDED, model.getPath(MainTreeNode.this), idx, idx);
		}
	}

	@Override
	public void remove(int index) {
		groupTreeNodes.remove(index);
		model.fireEvent(TreeDataEvent.INTERVAL_REMOVED, model.getPath(MainTreeNode.this), index, index);
	}

	@Override
	public void remove(TreeNode child) {
		int idx = groupTreeNodes.indexOf(child);
		remove(idx);
	}

	@Override
	public Object clone() {
		return this;
	}

	private void createChilds() {
		for (Group group: groups) {
			TreeNode node = new GroupTreeNode(this, group);
			add(node);
		}
	}
}
