package tree;

import model.Student;
import org.zkoss.zul.DefaultTreeNode;

/**
 * TODO: comment
 * @author lazarev_nv 06.05.2014   17:20
 */
public class StudentTreeNode extends DefaultTreeNode<Student> {
	private boolean isInCouncil;
	public StudentTreeNode(Student data) {
		super(data);
	}

	public boolean isInCouncil() {
		return isInCouncil;
	}

	public void setInCouncil(boolean isInCouncil) {
		this.isInCouncil = isInCouncil;
	}
}
