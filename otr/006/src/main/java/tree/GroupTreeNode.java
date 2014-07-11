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
<<<<<<< HEAD
 * Tree node for group
=======
 * TODO: comment
>>>>>>> Try new nodes structure
 * @author lazarev_nv 06.05.2014   17:21
 */
public class GroupTreeNode implements TreeNode {
	private MainTreeNode rootTreeNode;
	private List<TreeNode> studentTreeNodes = new ArrayList<TreeNode>();
<<<<<<< HEAD

	public Group getGroup() {
		return group;
	}

=======
>>>>>>> Try new nodes structure
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
<<<<<<< HEAD
		if (node instanceof StudentTreeNode) {
			StudentTreeNode studentTreeNode = (StudentTreeNode) node;
			Student student = studentTreeNode.getData();
			for (int i=0; i<studentTreeNodes.size(); i++) {
				StudentTreeNode treeNode = (StudentTreeNode) studentTreeNodes.get(i);
				if (student.equals(treeNode.getData())) {
					return i;
				}
			}
		}
=======
>>>>>>> Try new nodes structure
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
<<<<<<< HEAD
			StudentTreeNode node = new StudentTreeNode(this, student);
			node.setInCouncil((group.getCouncil().isInCouncil(student)));
			node.setGroupTreeNode(this);
=======
			TreeNode node = new StudentTreeNode(student);
>>>>>>> Try new nodes structure
			add(node);
		}
	}

	@Override
	public String toString() {
		return group.toString();
	}
}
