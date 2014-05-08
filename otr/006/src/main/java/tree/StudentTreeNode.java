package tree;

import model.Student;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.event.TreeDataEvent;

/**
 * Tree node for student
 * @author lazarev_nv 06.05.2014   17:20
 */
public class StudentTreeNode extends DefaultTreeNode<Student> {
	private boolean isInCouncil;
	private GroupTreeNode groupTreeNode;

	public StudentTreeNode(GroupTreeNode groupTreeNode,Student data) {
		super(data);
		this.groupTreeNode = groupTreeNode;
	}

	public GroupTreeNode getGroupTreeNode() {
		return groupTreeNode;
	}

	public void setGroupTreeNode(GroupTreeNode groupTreeNode) {
		this.groupTreeNode = groupTreeNode;
	}

	public boolean isInCouncil() {
		return isInCouncil;
	}

	public void setInCouncil(boolean isInCouncil) {
		this.isInCouncil = isInCouncil;
		int index = groupTreeNode.getIndex(this);
		getModel().fireEvent(TreeDataEvent.CONTENTS_CHANGED, getModel().getPath(getGroupTreeNode()), index, index);
	}

	@Override
	public DefaultTreeModel getModel() {
		return groupTreeNode.getModel();
	}

}
